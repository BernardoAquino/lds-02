import React from 'react';

/** Hooks */
import useVehicles from '../../../hooks/useVehicles';

/** Components */
import List from '../../Atoms/List';
import Vehicle from './Vehicle';

/** Style */
import * as El from './VehicleList.style';

export type VehicleData = {
  name: string;
  isLeased: boolean;
}

const VehicleList = () => {
  const { vehicles, error } = useVehicles();

  if (!!error) {
    return (
      <El.ErrorMessage>Ooops... ocorreu um erro :(</El.ErrorMessage>
    )
  }

  if (vehicles?.length <= 0) {
    return (
      <El.ErrorMessage>Você ainda não possui veículos cadastrados</El.ErrorMessage>
    )
  }

  return (
    <List
      columns={[3,1]}
      items={vehicles}
      render={(item: VehicleData, index: number) => (
        <Vehicle key={`${item.name}-${index}`} {...item} />
      )}
    />
  )
}

export default VehicleList;
