package vitorota.mvvm.view.ui


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import vitorota.mvvm.R
import kotlinx.android.synthetic.main.fragment_project.*
import vitorota.mvvm.di.Injectable
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.viewmodel.ProjectViewModel
import javax.inject.Inject

class ProjectFragment : androidx.fragment.app.Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProjectViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectViewModel) {
        viewModel.setProjectId(arguments?.getString(KEY_PROJECT_ID)?:"")
        viewModel.projectObservable.observe(this, Observer<Project> {
            tvRepoName.text = it?.name
            tvRepoDetails.text = it?.description
        })
    }


    companion object {

        private val KEY_PROJECT_ID = "project_id"


        fun getInstance(projectId:String?) : ProjectFragment{
            val fragment = ProjectFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_ID, projectId)

            fragment.arguments = args

            return fragment
        }
    }

}
