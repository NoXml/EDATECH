import {
    FETCH_ENTITIES,
    FETCH_ENTITIES_SUCCESS,
    FETCH_ENTITIES_ERROR
} from './actions';

const initialState = {
    list: []
};

const entityReducer = (state = initialState, action) => {   
    switch (action.type) {
        case FETCH_ENTITIES:
            return {
                ...state,
                isEntitiesFetching: true
            };

        case FETCH_ENTITIES_SUCCESS:
            return {
                ...state
            };

        case FETCH_ENTITIES_ERROR:
            return {
                ...state
            };

        default:
            return state;
    }
};

export default entityReducer;