import React from 'react';
import PropTypes from 'prop-types';
import {StyleSheet, Text, TouchableHighlight} from "react-native";


export default class Todo extends React.Component {


    _onPress = () => {
        if (this.props.onClick) {
            this.props.onClick(this.props.id);
        }
    };
    _onLongPress = () => {
        if (this.props.onLongClick) {
            this.props.onLongClick(this.props.id);
        }
    };

    render() {
        return (
            <TouchableHighlight
                onPress={this._onPress}
                onLongPress={this._onLongPress}
                style={
                    {
                        backgroundColor: this.props.index % 2 == 0 ? '#FFFFFF' : '#e7e7e7',
                        height: 60
                    }
                }>
                <Text style={this.props.completed ? styles.textCompleted : styles.text}>
                    {' ' + this.props.text + ' '}
                </Text>
            </TouchableHighlight>
        );
    }
}

const styles = StyleSheet.create({
    text: {
        padding: 10,
        // backgroundColor: 'steelblue',
        color: 'black',
        fontSize: 16,
        textDecorationLine: 'none',
    },
    textCompleted: {
        padding: 10,
        // backgroundColor: 'steelblue',
        color: 'gray',
        fontSize: 16,
        textDecorationLine: 'line-through'
    }

});

Todo.propTypes = {
    id: PropTypes.string.isRequired,
    index: PropTypes.number.isRequired,
    completed: PropTypes.bool.isRequired,
    text: PropTypes.string.isRequired,
    onClick: PropTypes.func.isRequired,
    onLongClick: PropTypes.func.isRequired,
};