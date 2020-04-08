import React, {useState} from 'react';

const App = () => {
	const [status, setStatus] = useState({
		isFetching: false,
		data: null
	});

	const {isFetching, data} = status;

	const handleOnStatusClick = async () => {
		setStatus({
			...status,
			isFetching: true
		});

		const response = await fetch('http://localhost:8090/status');
		const data = await response.text();

		setStatus({
			...status,
			isFetching: false,
			data
		});
	};

	const divStyles = {
		cursor: 'pointer',
		...(isFetching && {pointerEvents: 'none'})
	};
	const formatedData = isFetching ? 'Loading ...' : typeof data === 'string' ? data || 'No status'  : 'Click above to fetch';

	return (
		<div>
			<div onClick={handleOnStatusClick} style={divStyles}>GET STATUS</div>
			<h1>{formatedData}</h1>
		</div>
	);
};

export default App;
