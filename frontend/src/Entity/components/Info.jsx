import React from 'react';
import {Alert} from 'react-bootstrap';
import {StyledCenterRow} from './styledComponents';

const Info = () => (
    <StyledCenterRow>
        <Alert variant="danger">Error from server: information</Alert>
    </StyledCenterRow>
);

export default Info;
