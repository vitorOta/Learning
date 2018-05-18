import thunkMiddleware from 'redux-thunk';
import {createLogger} from 'redux-logger';
import {createStore, applyMiddleware} from 'redux';
import {fetchPostsIfNeeded} from './redux/actions';
import rootReducer from './redux/reducers';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


const loggerMiddleware = createLogger();

const store = createStore(
    rootReducer,
    applyMiddleware(
        thunkMiddleware, //let us dispatch() functions
        loggerMiddleware //neat middleware that logs actions
    ));

ReactDOM.render(
    (
        <div>
            HelloWorld {store.getState().selectedSubreddit}
        </div>
    ),
    document.getElementById('root')
);


// store.dispatch(selectSubreddit('reactjs'));
// store.dispatch(fetchPosts('reactjs'))
//     .then(() => console.log(store.getState()));

store.dispatch(fetchPostsIfNeeded('reactjs'))
    .then(() => console.log(store.getState()));