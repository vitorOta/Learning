import React from 'react';
import {Alert, Button, StyleSheet, Text, View} from 'react-native';

export default class Screen2 extends React.Component{
    render() {
        return(
            <View style={styles.container}>
                <Text>Screen 2</Text>
                <View
                    style={{width: 50, height: 50, backgroundColor: '#00f'}}/>
                <Button onPress={()=>this.props.navigation.navigate('MyScreen1')} title="Go to screen 1"/>
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
