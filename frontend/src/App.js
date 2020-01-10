import React, {useEffect} from 'react';
import logo from './logo.svg';
import './App.css';



const App = () => {


	useEffect(() => {

		const asyncRequests = async () => {
			let response;

			response = await fetch('/status', {
				method: 'GET',
				body: JSON.stringify({name: 'test'})
			});

			if (response.status !== 200) alert('NOT 200 RESPONSE!');
		};
		asyncRequests();


	}, []);

  	return (
    	<div>
			EDATECH
    	</div>
  	);
}

export default App;