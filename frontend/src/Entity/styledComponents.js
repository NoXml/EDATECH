import {Button} from 'react-bootstrap';
import Loader from 'react-loader-spinner';
import styled from 'styled-components';

export const StyledWrapper = styled.div`
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
`;

export const StyledCenterRow = styled.div`
	align-self: stretch;
	display: flex;
	justify-content: center;
	align-items: center;

	padding: 20px 40px;
`;

export const StyledControlsInnerWrapper = styled.div`
	display: flex;
	flex-direction: row;
	justify-content: ${props => props.start ? 'flex-start' : 'center'};
	align-items: center;
`;

export const StyledButton = styled(Button)`
	box-shadow: none !important;
	margin-left: ${props => props.leftMargin ? `${props.leftMargin}px` : 0};
`;

export const StyledLoader = styled(Loader)`
	& > svg {
		fill: var(--green);
	}
`;

export const StyledThActions = styled.th`
	width: 250px;
`;

export const StyledTd = styled.td`
	vertical-align: middle !important;
`;
