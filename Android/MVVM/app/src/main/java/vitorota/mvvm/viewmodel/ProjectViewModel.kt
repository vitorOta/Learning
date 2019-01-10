package vitorota.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.service.repository.ProjectRepository

class ProjectViewModel(
    application: Application,
    projectId: String
) : AndroidViewModel(application) {
    val projectObservable: LiveData<Project> = ProjectRepository.instance.getProjectDetails("Google", projectId)


    class Factory(private val application:Application, private val projectId:String) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProjectViewModel(application, projectId) as T
        }

    }
}