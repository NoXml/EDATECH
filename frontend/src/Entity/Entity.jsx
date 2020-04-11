import React from 'react';
import {StyledTd, StyledControlsInnerWrapper, StyledButton} from './styledComponents';

const Entity = () => {
    return (
        <tr>
            <StyledTd>1</StyledTd>
            <StyledTd>Mark</StyledTd>
            <td>
                <StyledControlsInnerWrapper start>
                    <StyledButton variant="primary">Update</StyledButton>
                    <StyledButton leftMargin={15} variant="danger">Delete</StyledButton>
                </StyledControlsInnerWrapper>
            </td>
        </tr>
    );
};

export default Entity;
