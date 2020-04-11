export const FETCH_ENTITIES = 'FETCH_ENTITIES';
export const FETCH_ENTITIES_SUCCESS = 'FETCH_ENTITIES_SUCCESS';
export const FETCH_ENTITIES_ERROR = 'FETCH_ENTITIES_ERROR';

export const fetchEntities = () => ({
	type: FETCH_ENTITIES
});

export const fetchEntitiesSuccess = () => ({
	type: FETCH_ENTITIES_SUCCESS
});

export const fetchEntitiesError = () => ({
	type: FETCH_ENTITIES_ERROR
});