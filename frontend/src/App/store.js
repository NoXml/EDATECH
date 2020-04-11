import {createStore, applyMiddleware, compose, combineReducers} from 'redux';
import createSagaMiddleware from 'redux-saga';
import {fork, takeLatest, call, put} from 'redux-saga/effects';

import entity from 'Entity/reducer';
import {FETCH_ENTITIES, fetchEntitiesSuccess, fetchEntitiesError} from 'Entity/actions';

const reducer = combineReducers({entity});

function* fetchEntitiesSaga() {
	try {
        const response = yield call(() => fetch('http://localhost:8090/entity'));	
        console.log('response', response);
		yield put(fetchEntitiesSuccess());	
	} catch {
		yield put(fetchEntitiesError());
	}
};

function* watchEntity() {
	yield takeLatest(FETCH_ENTITIES, fetchEntitiesSaga);
};

function* rootSaga() {
    yield fork(watchEntity);
};

const sagaMiddleware = createSagaMiddleware();
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(reducer, composeEnhancers(applyMiddleware(sagaMiddleware)));
sagaMiddleware.run(rootSaga);

export default store;