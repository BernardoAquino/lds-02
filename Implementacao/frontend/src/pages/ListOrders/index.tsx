import React from 'react';

/** Components */
import OrderList from '../../components/Organisms/OrderList';

/** Layout */
import AuthLayout from '../../layout/AuthLayout';

const ListOrders = () => {
  return (
    <AuthLayout>
      <OrderList />
    </AuthLayout>
  )
}

export default ListOrders;
