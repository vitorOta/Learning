import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {createStore} from "redux";
import {Provider} from "react-redux";
import todoApp from "./redux/reducers";
import App from './components/App'


const store = createStore(todoApp);


ReactDOM.render(
    (<Provider store={store}>
        <App/>
    </Provider>)
    , document.getElementById('root')
);