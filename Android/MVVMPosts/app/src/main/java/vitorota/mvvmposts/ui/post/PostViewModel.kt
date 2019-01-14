package vitorota.mvvmposts.ui.post

import androidx.lifecycle.MutableLiveData
import vitorota.mvvmposts.base.BaseViewModel
import vitorota.mvvmposts.model.Post

/**
 *
 * @author Vitor Ota
 * @since 14/01/2019
 */
class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

}