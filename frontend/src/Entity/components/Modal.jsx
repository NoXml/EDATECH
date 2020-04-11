import React, {useState} from 'react';
import {Modal, Form} from 'react-bootstrap'
import {StyledButton, StyledLoader} from './styledComponents';

const {Header, Title, Body, Footer} = Modal;
const {Control} = Form;

const EntityModal = ({isEntityCreating, isEntityUpdating, title, id, currentName = null, actionButtonText, onAction, onClose}) => {
    const [name, setName] = useState('');
    
    const handleOnChange = event => setName(event.target.value.trim());
    const handleOnAction = () => onAction({id, name});

    const renderedControl = isEntityCreating || isEntityUpdating
        ? <StyledLoader type="Bars" color="var(--green)" height={100} width={100} />
        : <Control placeholder='Entity name' defaultValue={currentName} onChange={handleOnChange} />;
    const isActionDisabled = isEntityCreating || isEntityUpdating || name.length === 0 || name === currentName;

    return (
        <Modal show={true} onHide={onClose}>
            <Header closeButton>
                <Title>{title}</Title>
            </Header>
            <Body>{renderedControl}</Body>
            <Footer>
                <StyledButton variant='secondary' onClick={onClose}>
                    Close
                </StyledButton>
                <StyledButton disabled={isActionDisabled} variant='primary' onClick={handleOnAction}>
                    {actionButtonText}
                </StyledButton>
            </Footer>
      </Modal>
    );
};

export default EntityModal;
