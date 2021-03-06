package vitorota.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.service.repository.ProjectRepository
import javax.inject.Inject

class ProjectListViewModel @Inject constructor(
    projectRepository: ProjectRepository,
    application: Application
) : AndroidViewModel(application){
    val projectListObservable: LiveData<List<Project>> = projectRepository.getProjectList("Google")

}