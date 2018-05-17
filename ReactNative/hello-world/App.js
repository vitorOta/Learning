import React from 'react';
import {Alert, Button, StyleSheet, Text, View} from 'react-native';

export default class App extends React.Component {

    testMessage = ()=>Alert.alert("oi", "fim");

    render() {
        return (
            <View style={styles.container}>
                <Text>Hello World !</Text>
                <View
                      style={{width: 50, height: 50, backgroundColor: '#f00'}}/>
                <Button onPress={this.testMessage} title="first button"/>
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
