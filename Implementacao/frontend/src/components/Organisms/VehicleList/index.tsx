import React from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { EDIT_CAR_URL } from '../../../constants';

/** Hooks */
import useVehicles from '../../../hooks/useVehicleList';

/** Components */
import List from '../../Atoms/List';
import Vehicle from './Vehicle';

/** Style */
import * as El from './VehicleList.style';

export type VehicleData = {
  id: number;
  name: string;
  isLeased: boolean;
}

const VehicleList = () => {
  const navigate = useNavigate();
  const { vehicles, error, isLoading, deleteVehicle } = useVehicles<VehicleData>();

  if (isLoading) {
    return (
      <El.Message>Carregando...</El.Message>
    )
  }

  if (!!error) {
    return (
      <El.Message>Ooops... ocorreu um erro :(</El.Message>
    )
  }

  if (vehicles?.length <= 0) {
    return (
      <El.Message>Você ainda não possui veículos cadastrados</El.Message>
    )
  }

  const redirectToEditUrl = (itemId: number) => {
    const URL = EDIT_CAR_URL.replace(':id', `${itemId}`);

    navigate(URL);
  }


  return (
    <List
      keyPrefix='vehicleList-item'
      columns={[3,1]}
      items={vehicles}
      render={(item: VehicleData, index: number) => (
        <Vehicle
          key={`${item.name}-${index}`} 
          {...item}
          onEdit={() => redirectToEditUrl(item.id)}
          onDelete={() => deleteVehicle(item)}
        />
      )}
    />
  )
}

export default VehicleList;
