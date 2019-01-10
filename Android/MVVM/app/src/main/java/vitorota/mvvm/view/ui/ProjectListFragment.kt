package vitorota.mvvm.view.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_project_list.*
import vitorota.mvvm.R
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.view.adapter.ProjectAdapter
import vitorota.mvvm.viewmodel.ProjectListViewModel

class ProjectListFragment : Fragment() {

    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_project_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projectAdapter = ProjectAdapter(::show)
        recyclerView.adapter = projectAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        showLoading()
    }

    fun show(project: Project) {
        activity?.let {
            val projectFragment = ProjectFragment.getInstance(project.name)

            it.supportFragmentManager
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container, projectFragment)
                .commit()
        }


    }

    //gmb
    fun showLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    //gmb
    fun hideLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        viewModel.projectListObservable.observe(
            this,
            Observer<List<Project>> {
                projectAdapter.setItems(it)
                hideLoading()
            }
        )
    }

    companion object {
        fun getInstance(): ProjectListFragment {
            val fragment: ProjectListFragment = ProjectListFragment()

            return fragment
        }
    }


}
