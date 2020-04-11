import React, {useRef} from 'react';
import {useSelector} from 'react-redux';

import useActions from 'App/hooks/useActions';
import {
	openModal as bindOpenModal, 
	closeModal as bindCloseModal,
	createEntity as bindCreateEntity,
	updateEntity as bindUpdateEntity,
	deleteEntity as bindDeleteEntity
} from './redux/actions';
import useFetchEntities from './hooks/useFetchEntities';

import Title from './components/Title';
import Controls from './components/Controls';
// import Info from './components/Info';
import Table from './components/Table';
import Modal from './components/Modal';

import {StyledWrapper, StyledLoader} from './components/styledComponents';

const EntityContainer = () => {
	const [
		openModal, 
		closeModal, 
		createEntity, 
		updateEntity,
		deleteEntity
	] = useActions([
		bindOpenModal, 
		bindCloseModal, 
		bindCreateEntity, 
		bindUpdateEntity,
		bindDeleteEntity]);

	const modalAction = useRef(null);

	const isEntitiesFetching = useSelector(state => state.entity.isEntitiesFetching);
	const isEntityCreating = useSelector(state => state.entity.isEntityCreating);
	const isEntityUpdating = useSelector(state => state.entity.isEntityUpdating);
	const modal = useSelector(state => state.entity.modal);
	const entities = useSelector(state => state.entity.list);

	useFetchEntities();

	const isTableShow = !isEntitiesFetching && entities.length > 0;
	const isModalOpen = !!modal;
	const {
		title, 
		id,
		currentName, 
		actionButtonText
	} = modal || {};

	const handleOnCreateEntity = () => {
		modalAction.current = createEntity;
		openModal({
			title: 'Create new entity',
			actionButtonText: 'Create'
		});
	};
	const handleOnUpdateEntity = ({id, name}) => {
		modalAction.current = updateEntity;
		openModal({
			title: `Update entity with id: ${id}`,
			id,
			currentName: name,
			actionButtonText: 'Update'
		});
	};
	const handleOnDeleteEntity = id => deleteEntity(id);
	const handleOnClose = () => {
		modalAction.current = null;
		closeModal();
	};

	return (
		<StyledWrapper>
			<Title />
			<Controls onGetAll={() => {}} onCreate={handleOnCreateEntity} />
			{/* <Info /> */}
			{isEntitiesFetching && <StyledLoader type="Bars" color="var(--green)" height={100} width={100} />}
			{isTableShow && <Table entities={entities} onUpdateEntity={handleOnUpdateEntity} onDeleteEntity={handleOnDeleteEntity} />}
			{isModalOpen && <Modal 
				isEntityCreating={isEntityCreating} 
				isEntityUpdating={isEntityUpdating}
				title={title} 
				id={id}
				currentName={currentName}
				actionButtonText={actionButtonText} 
				onAction={modalAction.current} 
				onClose={handleOnClose} 
			/>}
		</StyledWrapper>
	);
};

export default EntityContainer;
