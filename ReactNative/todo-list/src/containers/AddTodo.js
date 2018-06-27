import React from "react";
import {addTodo} from "../redux/actions";
import {Button, TextInput, View} from "react-native";
import {connect} from "react-redux";

class AddTodoCmp extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text: ''
        };
    }

    _onPressButton = () => {
        let {text} = this.state;
        if (text.trim().length == 0) {
            return;
        }

        this.props.addTodo(text);

        this.setState({text: ''});
    };

    render() {
        return (
            <View>
                <TextInput placeholder="Nova tarefa"
                           value={this.state.text}
                           onChangeText={(text) => this.setState({text})}/>
                <Button title="+ Adicionar" style={{height:80}} onPress={this._onPressButton}/>
            </View>
        );
    }
}

const mapStateToProps = state => {
    return {
    };
};

const mapDispatchToProps = dispatch => {
    return {
        addTodo: text => {
            dispatch(addTodo(text));
        }
    };
};

const AddTodo = connect(mapStateToProps,mapDispatchToProps)(AddTodoCmp);
export default AddTodo;