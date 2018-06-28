import React from 'react';
import {connect} from 'react-redux';
import TodoList from "../components/TodoList";
import {removeTodo, toggleTodo, VisibilityFilters} from "../redux/actions";
import {Alert} from "react-native";


const {SHOW_ALL, SHOW_ACTIVE, SHOW_COMPLETED} = VisibilityFilters;

const getVisibleTodos = (todos, filter)=>{
    switch (filter) {
        case SHOW_COMPLETED:
            return todos.filter(t => t.completed);
        case SHOW_ACTIVE:
            return todos.filter(t => !t.completed);
        case SHOW_ALL:
        default:
            return todos;
    }
}

const mapStateToProps = state => {
    return {
        todos: getVisibleTodos(state.todos, state.visibilityFilter),
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onTodoClick: id => {
            dispatch(toggleTodo(id));
        },
        onTodoLongClick: id => {

            Alert.alert('Excluir nota', 'Deseja excluir essa nota?',
                [
                    {text:'Sim', onPress: ()=> dispatch(removeTodo(id))},
                    {text:'Não'},
                ]);
        }
    };
};

const VisibleTodoList = connect(mapStateToProps, mapDispatchToProps)(TodoList);

export default VisibleTodoList;