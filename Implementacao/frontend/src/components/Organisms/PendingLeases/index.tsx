import React from 'react';

/** Hooks */
import usePendingLeases, { PendingLease } from '../../../hooks/usePendingLeases';
import { useSession } from '../../../providers/Auth';

/** Components */
import List from '../../Atoms/List';
import PendingLeaseItem from './PendingLeaseItem';

/** Style */
import * as El from './PendingLeaseList.style';

const PendingLeaseList = () => {
  const { session } = useSession();
  const { leases, error, cancelLease, validateLease } = usePendingLeases();

  if (!!error) {
    return (
      <El.ErrorMessage>Ooops... ocorreu um erro :(</El.ErrorMessage>
    )
  }

  if (leases?.length <= 0) {
    return (
      <El.ErrorMessage>Você não possui pedidos pendentes</El.ErrorMessage>
    )
  }

  return (
    <List
      columns={[3,1]}
      items={leases}
      render={(item: PendingLease, index: number) => (
        <PendingLeaseItem
          key={`${item.vehicle}-${index}`} 
          isAgent={session.isAgent}
          onValidate={(approvedLease: boolean, hasCreditContract: boolean = false) => validateLease(item.id, approvedLease, hasCreditContract)}
          onCancel={() => cancelLease(item.id)}
          {...item} 
        />
      )}
    />
  )
}

export default PendingLeaseList;
