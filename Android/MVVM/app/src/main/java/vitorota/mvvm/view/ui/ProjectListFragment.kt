package vitorota.mvvm.view.ui


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_project_list.*
import vitorota.mvvm.R
import vitorota.mvvm.di.Injectable
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.view.adapter.ProjectAdapter
import vitorota.mvvm.viewmodel.ProjectListViewModel
import javax.inject.Inject

class ProjectListFragment : androidx.fragment.app.Fragment(), Injectable {

    private lateinit var projectAdapter: ProjectAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)

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

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProjectListViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        viewModel.projectListObservable.observe(
            this,
            Observer<List<Project>> {
                projectAdapter.submitList(it)
                hideLoading()
            }
        )
    }

    companion object {

        val TAG:String = this::class.java.name

        fun getInstance(): ProjectListFragment {
            val fragment: ProjectListFragment = ProjectListFragment()

            return fragment
        }
    }


}
