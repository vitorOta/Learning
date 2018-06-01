import React from 'react';
import PropTypes from 'prop-types';
import {StyleSheet, Text, TouchableHighlight} from "react-native";

export default class Todo extends React.Component {
    render() {
        //TODO increment
        return (
            <TouchableHighlight onPress={this.props.onClick} underlayColor="#ddd">
                <Text style={this.props.completed ? styles.completed : styles.normal}>
                    {this.props.text}
                </Text>
            </TouchableHighlight>
        );
    }
}

const styles = StyleSheet.create({
    normal: {
        textDecorationLine: 'none'
    },
    completed: {
        textDecorationLine: 'line-through'
    }
});

Todo.propTypes = {
    onClick: PropTypes.func.isRequired,
    completed: PropTypes.bool.isRequired,
    text: PropTypes.string.isRequired,
};