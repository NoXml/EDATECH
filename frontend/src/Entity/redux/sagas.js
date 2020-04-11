import {takeEvery, call, put} from 'redux-saga/effects';

import {
    FETCH_ENTITIES, 
    fetchEntitiesSuccess, 
    fetchEntitiesError, 

    closeModal,

    CREATE_ENTITY,
    createEntitySuccess,
    createEntityError,

    UPDATE_ENTITY,
    updateEntitySuccess,
    updateEntityError,

    DELETE_ENTITY, 
    deleteEntitySuccess, 
    deleteEntityError
} from './actions';

function* fetchEntitiesSaga() {
	try {
        const response = yield call(() => fetch('http://localhost:8090/entity'));
        const json = yield response.json();
        const {result} = json;

		yield put(fetchEntitiesSuccess(result));	
	} catch {
		yield put(fetchEntitiesError());
	}
};

function* createEntitySaga(action) {
    const {name} = action;

	try {
        const response = yield call(() => fetch('http://localhost:8090/entity', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name})
        }));
        const json = yield response.json();
        const {result} = json;

        yield put(createEntitySuccess(result));
        yield put(closeModal());
	} catch {
		yield put(createEntityError());
	}
};

function* updateEntitySaga(action) {
    const {id, name} = action;

	try {
        const response = yield call(() => fetch('http://localhost:8090/entity', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id, name})
        }));
        const json = yield response.json();
        const {result} = json;

        yield put(updateEntitySuccess(result));	
        yield put(closeModal());
	} catch {
		yield put(updateEntityError());
	}
};

function* deleteEntitySaga(action) {
    const {id} = action;

	try {
        const response = yield call(() => fetch(`http://localhost:8090/entity/${id}`, {
            method: 'DELETE'
        }));
        const json = yield response.json();
        const {result} = json;

        yield put(deleteEntitySuccess(result));	
	} catch {
		yield put(deleteEntityError({id}));
	}
};

export default function* watchEntity() {
    yield takeEvery(FETCH_ENTITIES, fetchEntitiesSaga);
    yield takeEvery(CREATE_ENTITY, createEntitySaga);
    yield takeEvery(UPDATE_ENTITY, updateEntitySaga);
    yield takeEvery(DELETE_ENTITY, deleteEntitySaga);
};