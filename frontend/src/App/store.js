import {createStore, applyMiddleware, compose, combineReducers} from 'redux';
import createSagaMiddleware from 'redux-saga';
import {fork} from 'redux-saga/effects';

import watchEntity from 'Entity/redux/sagas';
import entity from 'Entity/redux/reducer';

const reducer = combineReducers({entity});
function* rootSaga() {
    yield fork(watchEntity);
};

const sagaMiddleware = createSagaMiddleware();
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(reducer, composeEnhancers(applyMiddleware(sagaMiddleware)));
sagaMiddleware.run(rootSaga);

export default store;