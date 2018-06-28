import React from "react";
import {connect} from "react-redux";
import {setVisibilityFilter, VisibilityFilters} from "../redux/actions";
import ButtonFilters from "../components/ButtonFilters";

const {SHOW_ALL, SHOW_ACTIVE, SHOW_COMPLETED} = VisibilityFilters;

const mapStateToProps = state => {
    return {
        options: [
            {
                title: 'Todas',
                value: SHOW_ALL,
            },
            {
                title: 'Ativas',
                value: SHOW_ACTIVE,
            },
            {
                title: 'Concluídas',
                value: SHOW_COMPLETED,
            },
        ],
        initialSelected: state.visibilityFilter,
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onClick: filter => {
            dispatch(setVisibilityFilter(filter));
        }
    };
};


const VisibilityFilter = connect(mapStateToProps, mapDispatchToProps)(ButtonFilters);

export default VisibilityFilter;