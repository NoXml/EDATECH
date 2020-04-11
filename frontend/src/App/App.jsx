import React from 'react';
import {Provider} from 'react-redux';

import store from 'App/store';
import EntityContainer from 'Entity';

const App = () => (
	<Provider store={store}>
		<EntityContainer />
	</Provider>
);

export default App;
