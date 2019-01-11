package vitorota.mvvmposts.network

import io.reactivex.Observable
import retrofit2.http.GET
import vitorota.mvvmposts.model.Post

/**
 *
 * @author Vitor Ota
 * @since 11/01/2019
 */
interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

}