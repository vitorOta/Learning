package vitorota.mvvm.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vitorota.mvvm.service.model.Project

class ProjectRepository {
    private val gitHubService: GitHubService

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //TODO remove - will be injected using Dagger later
        gitHubService = retrofit.create(GitHubService::class.java)
    }

    fun getProjectList(user: String): LiveData<List<Project>> {
        val data: MutableLiveData<List<Project>> = MutableLiveData()

        val callback = object : Callback<List<Project>> {
            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                if (response.isSuccessful)
                    data.value = response.body()
            }
        }

        gitHubService.getProjectList(user).enqueue(callback)

        return data
    }


    fun getProjectDetails(userId: String, repoName: String): LiveData<Project> {
        val data: MutableLiveData<Project> = MutableLiveData()

        val callback = object : Callback<Project> {
            override fun onFailure(call: Call<Project>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                data.value = response.body()
            }
        }

        gitHubService.getProjectDetails(userId, repoName)
            .enqueue(callback)

        return data
    }

    companion object {
        //TODO remove - will be injected by Dagger later
        val instance by lazy {
            ProjectRepository()
        }
    }


}