import React from 'react';

/** Hooks */
import useOrders from '../../../hooks/useOrders';

/** Components */
import List from '../../Atoms/List';
import Order from './Order';

/** Style */
import * as El from './OrderList.style';

export type OrderData = {
  name: string;
  isLeased: boolean;
}

const OrderList = () => {
  const { orders, error } = useOrders();

  if (!!error) {
    return (
      <El.ErrorMessage>Ooops... ocorreu um erro :(</El.ErrorMessage>
    )
  }

  if (orders?.length <= 0) {
    return (
      <El.ErrorMessage>Você não possui pedidos pendentes</El.ErrorMessage>
    )
  }

  return (
    <List
      columns={[3,1]}
      items={orders}
      render={(item: OrderData, index: number) => (
        <Order key={`${item.name}-${index}`} {...item} />
      )}
    />
  )
}

export default OrderList;
