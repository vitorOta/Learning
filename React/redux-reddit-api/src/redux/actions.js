import fetch from 'cross-fetch';


export const SELECT_SUBREDDIT = 'SELECT_SUBREDDIT';
export const selectSubreddit = (subreddit) => {
    return {
        type: SELECT_SUBREDDIT,
        subreddit
    };
};


export const INVALIDATE_SUBREDDIT = 'INVALIDATE_SUBREDDIT';
export const invalidateSubreddit = (subreddit) => {
    return {
        type: SELECT_SUBREDDIT,
        subreddit
    };
};


export const REQUEST_POSTS = 'REQUEST_POSTS';

function requestPosts(subreddit) {
    return {
        type: REQUEST_POSTS,
        subreddit
    };
}


export const RECEIVE_POSTS = 'RECEIVE_POSTS';

function receivePosts(subreddit, json) {
    return {
        type: RECEIVE_POSTS,
        subreddit,
        posts: json.data.children.map(child => child.data),
        receivedAt: Date.now()
    };
}

//network actions (thunk action creators)
export const fetchPosts = (subreddit) => {
    return function (dispatch) {
        //inform the begin of the request
        dispatch(requestPosts(subreddit));

        return fetch(`https://www.reddit.com/r/${subreddit}.json`)
            .then(
                response =>
                    response.json(),
                //do not use catch here because of a bug (https://github.com/facebook/react/issues/6895)
                error =>
                    console.log('An error ocurred.', error)
            ).then(json => dispatch(receivePosts(subreddit, json)));

    };
};


function shouldFetchPosts(state, subreddit) {
    const posts = state.postsBySubreddit[subreddit];
    if (!posts) {
        return true;
    } else if (posts.isFetching) {
        return false;
    } else {
        return posts.didInvalidate;
    }
}

export function fetchPostsIfNeeded(subreddit) {
    // Note that the function also receives getState()
    // which lets you choose what to dispatch next.

    // This is useful for avoiding a network request if
    // a cached value is already available.

    return (dispatch, getState) => {
        if (shouldFetchPosts(getState(), subreddit)) {
            //dispatch a thunk from thunk
            return dispatch(fetchPosts(subreddit));
        } else {
            //let the calling code know there's nothing to wait for.
            return Promise.resolve();
        }
    };

}