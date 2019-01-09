package vitorota.mvvm.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vitorota.mvvm.service.model.Project

class ProjectRepository {
    private val gitHubService: GitHubService? = null


    fun getProjectList(userId: String): LiveData<List<Project>> {
        val data: MutableLiveData<List<Project>> = MutableLiveData()


        gitHubService?.getProjectList(userId)?.enqueue(object : Callback<List<Project>> {
            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                if (response.isSuccessful)
                    data.value = response.body()
            }

            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return data
    }
}