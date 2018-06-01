import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import Todo from "./Todo";

export default class App extends React.Component {
    state = {
        completed: false,
    };

    render() {
        const {completed} = this.state;

        return (
            <View style={styles.container}>
                <Todo onClick={() => this.setState({completed: !completed})} completed={completed} text="Teste"/>
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
