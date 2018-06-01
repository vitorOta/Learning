import React from 'react';
import PropTypes from 'prop-types';
import {StyleSheet, Text} from "react-native";


export default class Todo extends React.Component {

    render() {
        //TODO increment
        return (
            <Text style={this.props.completed ? styles.textCompleted : styles.text}>
                {this.props.text}
            </Text>
        );
    }
}

const styles = StyleSheet.create({
    text: {
        padding: 10,
        backgroundColor: 'steelblue',
        color: 'white',
        fontSize: 16,
        textDecorationLine: 'none',
    },
    textCompleted: {
        padding: 10,
        backgroundColor: 'steelblue',
        color: 'white',
        fontSize: 16,
        textDecorationLine: 'line-through'
    }

});

Todo.propTypes = {
    onClick: PropTypes.func.isRequired,
    completed: PropTypes.bool.isRequired,
    text: PropTypes.string.isRequired,
};