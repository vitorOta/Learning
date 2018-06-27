import React from 'react';
import {connect} from 'react-redux';
import TodoList from "../components/TodoList";
import {removeTodo, toggleTodo} from "../redux/actions";
import {Alert} from "react-native";

const mapStateToProps = state => {
    return {
        todos: state.todos,
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