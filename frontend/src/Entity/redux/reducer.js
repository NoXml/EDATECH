import {removeProperty} from 'App/helpers';
import {
    FETCH_ENTITIES,
    FETCH_ENTITIES_SUCCESS,
    FETCH_ENTITIES_ERROR,

    OPEN_MODAL,
    CLOSE_MODAL,

    CREATE_ENTITY,
    CREATE_ENTITY_SUCCESS,

    UPDATE_ENTITY,
    UPDATE_ENTITY_SUCCESS,

    DELETE_ENTITY,
    DELETE_ENTITY_SUCCESS
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
                ...removeProperty(state, 'isEntitiesFetching'),
                list: [...action.result]
            };

        case FETCH_ENTITIES_ERROR:
            return removeProperty(state, 'isEntitiesFetching');

        case OPEN_MODAL:
            return {
                ...state,
                modal: {
                    title: action.title,
                    id: action.id,
                    currentName: action.currentName,
                    actionButtonText: action.actionButtonText
                }
            };
    
        case CLOSE_MODAL:
            return removeProperty(state, 'modal');    

        case CREATE_ENTITY:
            return {
                ...state,
                isEntityCreating: true
            };

        case CREATE_ENTITY_SUCCESS:
            return {
                ...removeProperty(state, 'isEntityCreating'),
                list: [...state.list, action.entity]
            }; 
            
        case UPDATE_ENTITY:
            return {
                ...state,
                list: state.list.map(entity => entity.id === action.id ? {...entity, isUpdating: true} : entity),
                isEntityUpdating: true
            };

        case UPDATE_ENTITY_SUCCESS:
            return {
                ...removeProperty(state, 'isEntityUpdating'),
                list: state.list.map(entity => entity.id === action.entity.id ? {...action.entity} : entity)
            };

        case DELETE_ENTITY:
            return {
                ...state,
                list: state.list.map(entity => entity.id === action.id ? {...entity, isDeleting: true} : entity)
            };
    
        case DELETE_ENTITY_SUCCESS:
            return {
                ...state,
                list: state.list.filter(entity => entity.id !== action.entity.id)
            };

        default:
            return state;
    }
};

export default entityReducer;