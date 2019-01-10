package vitorota.mvvm.service.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import vitorota.mvvm.service.model.Project

interface GitHubService {
    companion object {
        val HTTPS_API_GITHUB_URL: String
            get() = "https://api.github.com/"
    }


    @GET("users/{userId}/repos")
    fun getProjectList(@Path("userId") userId:String):Call<List<Project>>

    @GET("repos/{userId}/{repoName}")
    fun getProjectDetails(@Path("userId") userId:String, @Path("repoName") repoName:String):Call<Project>

}