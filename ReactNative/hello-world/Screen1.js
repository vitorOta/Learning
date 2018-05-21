import React from 'react';
import {Alert, Button, StyleSheet, Text, View} from 'react-native';

export default class Screen1 extends React.Component{

    // goToScreen2 =

    render() {
        return(
            <View style={styles.container}>
                <Text>Screen 1 a</Text>
                <View
                    style={{width: 50, height: 50, backgroundColor: '#0f0'}}/>
                <Button onPress={()=>this.props.navigation.navigate('MyScreen2')} title="Go to screen 2"/>
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
