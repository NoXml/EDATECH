import React from 'react';
import {Table} from 'react-bootstrap';

import Entity from './Entity';
import {StyledCenterRow, StyledThActions} from './styledComponents';

const EntityTable = ({entities, onUpdateEntity, onDeleteEntity}) => {
    const renderedEntities = entities.map(entity => <Entity key={entity.id} entity={entity} onUpdate={onUpdateEntity} onDelete={onDeleteEntity} />);

    return (
        <StyledCenterRow>
            <Table striped bordered hover responsive>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <StyledThActions>Actions</StyledThActions>
                    </tr>
                </thead>
                <tbody>
                    {renderedEntities}
                </tbody>
            </Table>
        </StyledCenterRow>
    );
};

export default EntityTable;
