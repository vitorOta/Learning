package vitorota.mvvm.view.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import vitorota.mvvm.R
import kotlinx.android.synthetic.main.fragment_project.*
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.viewmodel.ProjectViewModel

class ProjectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ProjectViewModel.Factory(activity!!.application, arguments?.getString(KEY_PROJECT_ID) ?:"")

        val viewModel = ViewModelProviders.of(this, factory).get(ProjectViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectViewModel) {
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
