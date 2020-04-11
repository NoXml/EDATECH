import React from 'react';
import Loader from 'react-loader-spinner';
import {Button} from 'react-bootstrap';
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

export const StyledControlsInnerWrapper = styled(({start, ...rest}) => <div {...rest} />)`
	display: flex;
	flex-direction: row;
	justify-content: ${props => props.start ? 'flex-start' : 'center'};
	align-items: center;
`;

export const StyledButton = styled(({leftMargin, ...rest}) => <Button {...rest} />)`
	box-shadow: none !important;
	margin-left: ${props => props.leftMargin ? `${props.leftMargin}px` : 0};
`;

export const StyledThActions = styled.th`
	width: 250px;
`;

export const StyledTd = styled.td`
	vertical-align: middle !important;
`;

export const StyledLoader = styled(Loader)`
	display: flex;
	justify-content: center;
	align-items: center;
`;
