import React from 'react';
import {StyleSheet, View} from 'react-native';
import VisibleTodoList from '../containers/VisibleTodoList';
import AddTodo from "../containers/AddTodo";
import VisibilityFilter from "../containers/VisibilityFilter";

export default class App extends React.Component {


    render() {
        return (
            <View style={styles.container}>
                <AddTodo/>
                <VisibleTodoList/>
                <VisibilityFilter/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        backgroundColor: '#ffffff',
        // alignItems: 'center',
        // justifyContent: 'center',
    },
});