import React from 'react';
import {StyledTd, StyledControlsInnerWrapper, StyledButton} from './styledComponents';

const Entity = ({entity, onUpdate, onDelete}) => {
    const {id, name, isDeleting} = entity;
    const deleteText = isDeleting ? 'Deleting...' : 'Delete';

    const handleOnUpdate = () => onUpdate({id, name});
    const handleOnDelete = () => onDelete(id);

    return (
        <tr>
            <StyledTd>{id}</StyledTd>
            <StyledTd>{name}</StyledTd>
            <td>
                <StyledControlsInnerWrapper start>
                    <StyledButton variant="primary" onClick={handleOnUpdate}>Update</StyledButton>
                    <StyledButton leftMargin={15} variant="danger" onClick={handleOnDelete}>{deleteText}</StyledButton>
                </StyledControlsInnerWrapper>
            </td>
        </tr>
    );
};

export default Entity;
