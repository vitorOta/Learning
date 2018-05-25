import React from 'react';
import {createStore} from "redux";
import todoApp from "./reducers";


const confgureStore = ()=>createStore(todoApp);

export default confgureStore;