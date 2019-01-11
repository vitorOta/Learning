package vitorota.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import vitorota.mvvm.service.model.Project
import vitorota.mvvm.service.repository.ProjectRepository
import javax.inject.Inject

class ProjectViewModel @Inject constructor(
    projectRepository: ProjectRepository,
    application: Application
) : AndroidViewModel(application) {

    val projectObservable: LiveData<Project>
    private val projectId: MutableLiveData<String> = MutableLiveData()

    init {
        projectObservable = Transformations.switchMap(projectId) {
            if (it.isEmpty()) {
                ABSENT
            } else {
                projectRepository.getProjectDetails("Google", it)
            }
        }
    }

    fun setProjectId(project:String){
        projectId.value = project
    }


    companion object {
        private val TAG: String = ProjectViewModel::class.java.name
        private val ABSENT: MutableLiveData<Project> = MutableLiveData()

        init {
            ABSENT.value = null
        }
    }

}