import React from 'react';
import {AppRegistry} from 'react-native';
import {Provider} from 'react-redux'
import {PersistGate} from 'redux-persist/integration/react';
import configureStore from './src/redux/configureStore'
import App from "./src/components/App";


const {store, persistor} = configureStore();

const ReduxApp = () => (
    <Provider store={store}>
        <PersistGate loading={null} persistor={persistor}>
            <App/>
        </PersistGate>
    </Provider>
);

AppRegistry.registerComponent('TodoList', () => ReduxApp);