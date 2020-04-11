import {useEffect} from 'react';
import useActions from 'App/hooks/useActions';
import {fetchEntities as bindFetchEntities} from '../redux/actions';

const useFetchEntities = () => {
    const fetchEntities = useActions(bindFetchEntities);
    useEffect(() => {
        fetchEntities();
    }, [fetchEntities]);
};

export default useFetchEntities;