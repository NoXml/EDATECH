import React, {useEffect} from 'react';
import logo from './logo.svg';
import './App.css';



const App = () => {


	useEffect(() => {

		const asyncRequests = async () => {
			let response;

			response = await fetch('/entity', {
				method: 'PUT',
				body: JSON.stringify({name: 'test'})
			});
	
			response = await fetch('/entity', {
				method: 'GET',
				body: JSON.stringify({id: 1})
			});
	
			response = await fetch('/entity', {
				method: 'POST',
				body: JSON.stringify({id: 1, name: 'test'})
			});
	
			response = await fetch('/entity', {
				method: 'DELETE',
				body: JSON.stringify({id: 1})
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