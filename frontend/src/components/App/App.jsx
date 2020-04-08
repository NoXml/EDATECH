import React from 'react';


const handleOnStatusClick = async () => {
	const response = await fetch('http://localhost:8090/entity', {mode : 'no-cors'});
	console.log('response', response);
	const status = await response.json();
};

const App = () => {
	return (
		<div onClick={handleOnStatusClick}>GET STATUS</div>
	);
};

export default App;
