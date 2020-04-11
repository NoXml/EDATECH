import {useMemo} from 'react';
import {bindActionCreators} from 'redux';
import {useDispatch} from 'react-redux';

const  useActions = actionsToBind => {
	const dispatch = useDispatch();

	return useMemo(() => {
			if (Array.isArray(actionsToBind)) return actionsToBind.map(action => bindActionCreators(action, dispatch));
			return bindActionCreators(actionsToBind, dispatch);
		},
		[actionsToBind, dispatch]
	);
}

export default useActions;
