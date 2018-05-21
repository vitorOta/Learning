import React from 'react';
import {Alert, Button, StyleSheet, Text, View} from 'react-native';
import {StackNavigator} from 'react-navigation';
import Screen1 from "./Screen1";
import Screen2 from "./Screen2";

const App = StackNavigator({
    MyScreen1: {screen: Screen1},
    MyScreen2: {screen: Screen2},
}, {initialRouteName: 'MyScreen1'});
export default App;

// export default class App extends React.Component {
//     render() {
//         return StackNavigator({
//             MyScreen1: {screen: Screen1},
//             MyScreen2: {screen: Screen2},
//         }, {initialRouteName: 'Screen'});
//     }
// }

// const styles = StyleSheet.create({
//     container: {
//         flex: 1,
//         backgroundColor: '#fff',
//         alignItems: 'center',
//         justifyContent: 'center',
//     },
// });
