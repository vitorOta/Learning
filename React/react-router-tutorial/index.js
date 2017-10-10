import React from 'react'
import { render } from 'react-dom'
import App from './modules/App'
import About from './modules/About'
import Repos from './modules/Repos'
import Repo from './modules/Repo'
import Home from './modules/Home'
import { Router, Route, hashHistory, IndexRoute } from 'react-router'

render(
    (
        <Router history={hashHistory}>
            <Route path="/" component={App}>
                <IndexRoute component={Home} />
                <Route path="/repos" component={Repos}>
                <Route path="/repos/:userName/:repoName" component={Repo} />
                </Route>
                <Route path="/about" component={About} />
            </Route>
        </Router>
    )
    , document.getElementById('app'))

    //stop on https://github.com/reactjs/react-router-tutorial/tree/master/lessons/10-clean-urls