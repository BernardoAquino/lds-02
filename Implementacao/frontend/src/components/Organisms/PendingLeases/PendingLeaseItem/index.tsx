import React from 'react';

/** Types */
import { PendingLease } from '../../../../hooks/usePendingLeases';

/** Component */
import Button from '../../../Atoms/Button';

/** Style */
import * as El from './PendingLeaseItem.style';

type PendingLeaseItemProps = PendingLease & {
  isAgent: boolean;
  onCancel: () => void;
  onValidate: (approvedLease: boolean, hasCreditContract?: boolean) => void;
}

const PendingLeaseItem = ({
  vehicle,
  owner,
  client,
  isAgent,
  onCancel,
  onValidate
}: PendingLeaseItemProps) => {
  return (
    <El.Card>
      <El.Info>
        <El.Vehicle>{vehicle}</El.Vehicle>
        <El.Client>Cliente: {client}</El.Client>
        <El.Owner>Proprietario: {owner}</El.Owner>
      </El.Info>
      <El.Actions>
        {isAgent ? (
          <>
            <Button onClick={() => onValidate(true, false)}>aprovar com contrato de credito</Button>
            <Button onClick={() => onValidate(true, true)}>aprovar sem contrato de credito</Button>
            <Button color={'secondary'} onClick={() => onValidate(true)}>negar</Button>
          </>
        ) : (
          <Button onClick={onCancel}>cancelar</Button>
        )}
      </El.Actions>
    </El.Card>
  )
}

export default PendingLeaseItem;