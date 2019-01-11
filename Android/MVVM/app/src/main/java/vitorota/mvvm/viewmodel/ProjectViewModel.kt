package vitorota.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
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