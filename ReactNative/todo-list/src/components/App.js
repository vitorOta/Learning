import React from 'react';
import {StyleSheet, View} from 'react-native';
import VisibleTodoList from '../containers/VisibleTodoList';
import AddTodo from "../containers/AddTodo";

export default class App extends React.Component {


    render() {
        return (
            <View style={styles.container}>
                <AddTodo/>
                <VisibleTodoList/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#ffffff',
        // alignItems: 'center',
        // justifyContent: 'center',
    },
});