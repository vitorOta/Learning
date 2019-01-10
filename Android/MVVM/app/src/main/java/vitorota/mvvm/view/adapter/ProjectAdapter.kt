package vitorota.mvvm.view.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
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
    ListAdapter<Project, ProjectAdapter.ProjectViewHolder>(ProjectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_list_item,parent,false)

        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProjectViewHolder, position: Int) {
        val project = getItem(position)
        viewHolder.bind(project, onClick)
    }

    class ProjectViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //why just not use in bind method? https://stackoverflow.com/questions/45951792/kotlin-android-extensions-in-viewholder
        private val tvRepoName: TextView = view.tvRepoName
        private val tvRepoDescription: TextView = view.tvRepoDetails

        fun bind(project: Project?, onClick: (project: Project) -> Unit) {

            tvRepoName.text = project?.name
            tvRepoDescription.text = project?.description

            view.setOnClickListener { onClick(project!!) }
        }
    }
}