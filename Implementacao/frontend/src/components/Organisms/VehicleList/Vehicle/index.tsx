import React from 'react';

/** Types */
import { VehicleData } from '../';

/** Style */
import * as El from './Vehicle.style';

const Vehicle = ({
  name,
  isLeased
}: VehicleData) => {
  return (
    <El.Card>
      <El.Info>
        <El.Name>{name}</El.Name>
        <El.Status isLeased={isLeased}>{isLeased ? 'Alugado' : 'Disponivel'}</El.Status>
      </El.Info>
    </El.Card>
  )
}

export default Vehicle;