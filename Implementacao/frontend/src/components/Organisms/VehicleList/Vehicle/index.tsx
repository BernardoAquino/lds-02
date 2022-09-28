import React from 'react';

/** Types */
import { VehicleData } from '../';
import Button from '../../../Atoms/Button';

/** Style */
import * as El from './Vehicle.style';

type VehicleProps = VehicleData & {
  onDelete: () => void;
  onEdit: () => void;
}

const Vehicle = ({
  name,
  isLeased,
  onDelete,
  onEdit
}: VehicleProps) => {
  return (
    <El.Card>
      <El.Info>
        <El.Name>{name}</El.Name>
        <El.Status isLeased={isLeased}>{isLeased ? 'Alugado' : 'Disponivel'}</El.Status>
      </El.Info>
      {!isLeased && (
        <El.Actions>
          <Button onClick={onEdit}>editar</Button>
          <Button color={'secondary'} onClick={onDelete}>remover</Button>
        </El.Actions>
      )}
    </El.Card>
  )
}

export default Vehicle;