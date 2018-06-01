import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import VisibleTodoList from '../containers/VisibleTodoList';

export default class App extends React.Component {
    state = {
        completed: false,
    };

    render() {
        const {completed} = this.state;

        return (
            <View style={styles.container}>
                <VisibleTodoList/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});
