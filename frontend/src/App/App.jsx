import React from 'react';
import {Provider} from 'react-redux';

import store from 'App/store';
import Entity from 'Entity';

const App = () => (
	<Provider store={store}>
		<Entity />
	</Provider>
);

export default App;
