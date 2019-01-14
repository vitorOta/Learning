package vitorota.mvvmposts.ui.post

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vitorota.mvvmposts.R
import vitorota.mvvmposts.base.BaseViewModel
import vitorota.mvvmposts.model.Post
import vitorota.mvvmposts.network.PostApi
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    val postListAdapter:PostListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrivePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { onRetrievePostListSuccess(it) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrivePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>) {
        postListAdapter.submitList(postList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}