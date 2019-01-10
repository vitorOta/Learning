package vitorota.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.service.repository.ProjectRepository

class ProjectListViewModel(
    application: Application
) : AndroidViewModel(application){
    val projectListObservable: LiveData<List<Project>> = ProjectRepository.instance.getProjectList("Google")

}