import React from 'react';
import {createStore} from 'redux';
import todoAppReducer from './reducers';

import {persistStore, persistReducer} from 'redux-persist';
import storage from 'redux-persist/lib/storage';


const persistConfig = {
    key: 'app',
    storage,
}
const persistedReducer = persistReducer(persistConfig, todoAppReducer);


export default () => {
    const store = createStore(persistedReducer);
    const persistor = persistStore(store);

    return {
        store,
        persistor
    };
}