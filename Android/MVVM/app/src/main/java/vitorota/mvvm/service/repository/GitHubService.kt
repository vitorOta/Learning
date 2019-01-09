package vitorota.mvvm.service.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import vitorota.mvvm.service.model.Project

interface GitHubService {
    val HTTPS_API_GITHUB_URL: String
        get() = "https://api.github.com/"

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user:String):Call<List<Project>>

    @GET("repos/{user}/{repoName}")
    fun getProjectDetails(@Path("user") user:String, @Path("repoName") repoName:String):Call<List<Project>>

}