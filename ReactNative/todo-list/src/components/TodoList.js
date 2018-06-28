import React from 'react';
import PropTypes from 'prop-types';
import {FlatList, StyleSheet} from "react-native";
import Todo from "./Todo";

export default class TodoList extends React.Component {

    extractKey = ({id}) => id;

    renderItem = ({item, index}) => (
        <Todo key={item.id} id={item.id} text={item.text} completed={item.completed} index={index}
              onClick={this.props.onTodoClick} onLongClick={this.props.onTodoLongClick}/>
    );

    render() {
        return (
            <FlatList
                style={styles.list}
                data={this.props.todos}
                keyExtractor={this.extractKey}
                renderItem={this.renderItem}
            />
        );
    }

};

const styles = StyleSheet.create({
    list: {
        flex: 1
    },
});

TodoList.propTypes = {
    todos: PropTypes.arrayOf(
        PropTypes.shape({
            id: PropTypes.string.isRequired,
            completed: PropTypes.bool.isRequired,
            text: PropTypes.string.isRequired
        })
    ).isRequired,
    onTodoClick: PropTypes.func.isRequired,
    onTodoLongClick: PropTypes.func.isRequired,
};