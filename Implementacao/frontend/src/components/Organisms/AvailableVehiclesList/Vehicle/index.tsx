import React from 'react';

/** Types */
import { LeaseVehicleData } from '..';
import Button from '../../../Atoms/Button';

/** Style */
import * as El from './Vehicle.style';

type VehicleProps = LeaseVehicleData & {
  onLease: () => void;
}

const Vehicle = ({
  name,
  owner,
  onLease,
}: VehicleProps) => {
  return (
    <El.Card>
      <El.Info>
        <El.Name>{name}</El.Name>
        <El.Owner>{owner}</El.Owner>
      </El.Info>
      <El.Actions>
        <Button onClick={onLease}>alugar</Button>
      </El.Actions>
    </El.Card>
  )
}

export default Vehicle;