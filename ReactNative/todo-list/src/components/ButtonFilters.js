import React from "react";
import PropTypes from "prop-types";
import {Button, StyleSheet, View} from "react-native";

export default class ButtonFilters extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            selected: this.props.initialSelected
        }
    }

    _onClick = (value) => {

        this.props.onClick(value);

        this.setState({
            selected: value
        });
    }

    render() {
        return (
            <View style={styles.container}>

                {/*<Button title='Teste' style={{flex:1}}/>*/}
                {/*<Button title='Xablau' style={{flex:2}}/>*/}
                {/*<Button title='What' style={{flex:1}}/>*/}

                {this.props.options.map(option => (
                    <Button
                        key={option.value}
                        title={option.title}
                        onPress={()=>this._onClick(option.value)}
                        style={styles.button}
                        color={this.state.selected === option.value ? 'steelblue' : 'gray'}/>
                ))}

            </View>
        );
    }
}


const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        height: 40
    },
    button: {
        flex:1
    }

});

ButtonFilters.defaultProps = {
    options: []
};

ButtonFilters.propTypes = {
    options: PropTypes.arrayOf(
        PropTypes.shape({
            title: PropTypes.string.isRequired,
            value: PropTypes.string.isRequired,
        })
    ).isRequired,
    initialSelected: PropTypes.string.isRequired,
    onClick: PropTypes.func.isRequired,
};