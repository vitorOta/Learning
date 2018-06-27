import React from "react";
import {addTodo} from "../redux/actions";

export class AddTodo extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            text:''
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

    }
}


const mapDispatchToProps = dispatch=>{
    return {
        addTodo: text=> {
            dispatch(addTodo(text));
        }
    };
};
