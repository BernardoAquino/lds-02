import React from 'react';

/** Components */
import AuthLayout from '../../layout/AuthLayout';
import OrderList from '../../components/Organisms/OrderList';

const ListOrders = () => {
  return (
    <AuthLayout>
      <OrderList />
    </AuthLayout>
  )
}

export default ListOrders;
