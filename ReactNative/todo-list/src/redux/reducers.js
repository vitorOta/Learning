import {combineReducers} from 'redux';
import {ADD_TODO, REMOVE_TODO, SET_VISIBILITY_FILTER, TOGGLE_TODO, VisibilityFilters} from "./actions";
import {generateGuid} from "../util/guid";


const {SHOW_ALL} = VisibilityFilters;

function visibilityFilter(state = SHOW_ALL, action) {
    switch (action.type) {
        case SET_VISIBILITY_FILTER:
            return action.filter;
        default:
            return state;
    }
}

function todos(state = [], action) {
    switch (action.type) {
        case ADD_TODO:
            return [
                ...state,
                {
                    id: generateGuid(),
                    text: action.text,
                    completed: false
                }
            ];

        case REMOVE_TODO:
            const newState = state.slice();
            const i = newState.findIndex(item => item.id === action.id);
            if (i >= 0) {
                newState.splice(i, 1);
            }
            return newState;

        case TOGGLE_TODO:
            const newState2 = state.slice();
            const i2 = newState2.findIndex(item => item.id === action.id);
            if (i2 >= 0) {
                const updatedTodo = newState2[i2];
                updatedTodo.completed = !updatedTodo.completed;
                newState2.splice(i2, 1, updatedTodo);
            }
            return newState2;
        default:
            return state;
    }

}

const todoApp = combineReducers({
    visibilityFilter,
    todos
});

export default todoApp;