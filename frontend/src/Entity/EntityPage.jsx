import React, {useEffect} from 'react';
import useActions from 'App/hooks/useActions';

import {fetchEntities as bindFetchEntities} from './actions';

import Title from './Title';
import Controls from './Controls';
import Info from './Info';
import Table from './Table';

import {StyledWrapper, StyledLoader} from './styledComponents';

const EntityPage = () => {
	const fetchEntities = useActions(bindFetchEntities);

	useEffect(() => {
		fetchEntities();
	}, [fetchEntities]);

	return (
		<StyledWrapper>
			<Title />
			<Controls />
			<Info />
			<StyledLoader type="Bars" color="green" height={100} width={100} />
			<Table />
		</StyledWrapper>
	);
};

export default EntityPage;
