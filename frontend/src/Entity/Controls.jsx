import React from 'react';
import {StyledCenterRow, StyledControlsInnerWrapper, StyledButton} from './styledComponents';

const Controls = () => {
    return (
        <StyledCenterRow>
            <StyledControlsInnerWrapper>
                <StyledButton variant="outline-primary" onClick={() => alert(123)}>Get all</StyledButton>
                <StyledButton leftMargin={15} variant="outline-secondary">Create new</StyledButton>
            </StyledControlsInnerWrapper>
        </StyledCenterRow>
    );
};

export default Controls;
