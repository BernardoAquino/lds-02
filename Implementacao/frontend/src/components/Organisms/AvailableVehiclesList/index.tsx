import React from 'react';

/** Hooks */
import useAvailableVehicles from '../../../hooks/useAvailableVehicles';

/** Components */
import List from '../../Atoms/List';
import Vehicle from './Vehicle';

/** Style */
import * as El from './AvailableVehiclesList.style';

export type LeaseVehicleData = {
  id: number;
  name: string;
  owner: string;
}

const VehicleList = () => {
  const { vehicles, error, isLoading, createLease } = useAvailableVehicles<LeaseVehicleData>();

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

  return (
    <List
      keyPrefix='availableVehiclesList-item'
      columns={[3,1]}
      items={vehicles}
      render={(item: LeaseVehicleData, index: number) => (
        <Vehicle
          key={`${item.name}-${index}`} 
          {...item}
          onLease={() => createLease(item.id)}
        />
      )}
    />
  )
}

export default VehicleList;
