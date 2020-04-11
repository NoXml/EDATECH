import React from 'react';
import {StyledCenterRow, StyledControlsInnerWrapper, StyledButton} from './styledComponents';

const Controls = ({onGetAll, onCreate}) => {
    return (
        <StyledCenterRow>
            <StyledControlsInnerWrapper>
                <StyledButton variant="outline-primary" onClick={onGetAll}>Get all</StyledButton>
                <StyledButton leftMargin={15} variant="outline-secondary" onClick={onCreate}>Create new</StyledButton>
            </StyledControlsInnerWrapper>
        </StyledCenterRow>
    );
};

export default Controls;
