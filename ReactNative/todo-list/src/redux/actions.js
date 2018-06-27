/*
 * action types
 */
export const ADD_TODO = 'ADD_TODO';
export const TOGGLE_TODO = 'TOGGLE_TODO';
export const REMOVE_TODO = 'REMOVE_TODO';
export const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER';


/*
 * other constants
 */

export const VisibilityFilters = {
    SHOW_ALL: 'SHOW_ALL',
    SHOW_COMPLETED: 'SHOW_COMPLETED',
    SHOW_ACTIVE: 'SHOW_ACTIVE'
};


/*
 * action creators
 */

export const addTodo = text => {
    return {type: ADD_TODO, text};
};

export const removeTodo = id => {
    return {type: REMOVE_TODO, id};
}

export const toggleTodo = id => {
    return {type: TOGGLE_TODO, id};
};

export const setVisibilityFilter = filter => {
    return {type: SET_VISIBILITY_FILTER, filter};
};
