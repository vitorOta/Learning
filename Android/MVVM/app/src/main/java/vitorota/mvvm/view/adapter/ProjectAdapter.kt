package vitorota.mvvm.view.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.project_list_item.view.*
import vitorota.mvvm.R
import vitorota.mvvm.service.model.Project

class ProjectAdapter(private val onClick:(project:Project) -> Unit) :
    RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    private var items: List<Project>? = null

    fun setItems(newItems: List<Project>?) {
        if (items == null || newItems == null) {
            items = newItems
            notifyItemRangeInserted(0, items?.size ?: 0)
        } else {
            val result: DiffUtil.DiffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int = items?.size ?: 0

                override fun getNewListSize(): Int = newItems.size

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    (items?.get(oldItemPosition)?.id ?: 0) == newItems[newItemPosition].id

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldItem: Project? = items?.get(oldItemPosition)
                    val newItem: Project = newItems[newItemPosition]

                    return oldItem != null &&
                            oldItem.id == newItem.id &&
                            oldItem.git_url == newItem.git_url
                }
            })

            this.items = newItems
            result.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_list_item,parent,false)

        return ProjectViewHolder(view, onClick)
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(viewHolder: ProjectViewHolder, position: Int) {
        val project = getItem(position)
        viewHolder.bind(project)
    }

    private fun getItem(position: Int): Project? = items?.get(position)

    class ProjectViewHolder(val view: View, val onClick: (project: Project) -> Unit) : RecyclerView.ViewHolder(view) {
        //why just not use in bind method? https://stackoverflow.com/questions/45951792/kotlin-android-extensions-in-viewholder
        private val tvRepoName: TextView = view.tvRepoName
        private val tvRepoDescription: TextView = view.tvRepoDetails

        fun bind(project: Project?) {

            tvRepoName.text = project?.name
            tvRepoDescription.text = project?.description

            view.setOnClickListener {
                onClick(project!!) //gmb
            }
        }
    }
}