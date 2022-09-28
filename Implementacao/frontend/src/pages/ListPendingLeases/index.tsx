import React from 'react';

/** Components */
import OrderList from '../../components/Organisms/PendingLeases';

/** Layout */
import AuthLayout from '../../layout/AuthLayout';

const ListPendingLeases = () => {
  return (
    <AuthLayout>
      <OrderList />
    </AuthLayout>
  )
}

export default ListPendingLeases;
