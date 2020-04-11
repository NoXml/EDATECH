export const FETCH_ENTITIES = 'FETCH_ENTITIES';
export const FETCH_ENTITIES_SUCCESS = 'FETCH_ENTITIES_SUCCESS';
export const FETCH_ENTITIES_ERROR = 'FETCH_ENTITIES_ERROR';

export const fetchEntities = () => ({
	type: FETCH_ENTITIES
});

export const fetchEntitiesSuccess = result => ({
    type: FETCH_ENTITIES_SUCCESS,
    result
});

export const fetchEntitiesError = () => ({
	type: FETCH_ENTITIES_ERROR
});

export const OPEN_MODAL = 'OPEN_MODAL';
export const CLOSE_MODAL = 'CLOSE_MODAL';

export const openModal = ({title, id, currentName, actionButtonText}) => ({
    type: OPEN_MODAL,
    title,
    id,
    currentName,
    actionButtonText
});

export const closeModal = () => ({
    type: CLOSE_MODAL
});

export const CREATE_ENTITY = 'CREATE_ENTITY';
export const CREATE_ENTITY_SUCCESS = 'CREATE_ENTITY_SUCCESS';
export const CREATE_ENTITY_ERROR = 'CREATE_ENTITY_ERROR';

export const createEntity = ({name}) => ({
    type: CREATE_ENTITY,
    name
});

export const createEntitySuccess = entity => ({
    type: CREATE_ENTITY_SUCCESS,
    entity
});

export const createEntityError = () => ({
    type: CREATE_ENTITY_ERROR
});

export const UPDATE_ENTITY = 'UPDATE_ENTITY';
export const UPDATE_ENTITY_SUCCESS = 'UPDATE_ENTITY_SUCCESS';
export const UPDATE_ENTITY_ERROR = 'UPDATE_ENTITY_ERROR';

export const updateEntity = ({id, name}) => ({
    type: UPDATE_ENTITY,
    id,
    name
});

export const updateEntitySuccess = entity => ({
    type: UPDATE_ENTITY_SUCCESS,
    entity
});

export const updateEntityError = () => ({
    type: UPDATE_ENTITY_ERROR
});

export const DELETE_ENTITY = 'DELETE_ENTITY';
export const DELETE_ENTITY_SUCCESS = 'DELETE_ENTITY_SUCCESS';
export const DELETE_ENTITY_ERROR = 'DELETE_ENTITY_ERROR';

export const deleteEntity = id => ({
    type: DELETE_ENTITY,
    id
});

export const deleteEntitySuccess = entity => ({
    type: DELETE_ENTITY_SUCCESS,
    entity
});

export const deleteEntityError = () => ({
    type: DELETE_ENTITY_ERROR
});
