import React from 'react';
import {Table} from 'react-bootstrap';
import Entity from './Entity';
import {StyledCenterRow, StyledThActions} from './styledComponents';

const EntityTable = () => {
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
                    <Entity />
                    <Entity />
                    <Entity />
                    <Entity />
                    <Entity />
                    <Entity />
                </tbody>
            </Table>
        </StyledCenterRow>
    );
};

export default EntityTable;
