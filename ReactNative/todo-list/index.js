import React from 'react';
import {AppRegistry} from 'react-native';
import {Provider} from 'react-redux'
import configureStore from './src/redux/configureStore'
import App from "./src/components/App";


const store = configureStore();

const ReduxApp = () =>
    <Provider store={store}>
        <App/>
    </Provider>;

AppRegistry.registerComponent('TodoList', () => ReduxApp);