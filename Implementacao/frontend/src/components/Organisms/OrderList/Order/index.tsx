import React from 'react';

/** Types */
import { OrderData } from '..';

/** Style */
import * as El from './Order.style';

const Order = ({
  name
}: OrderData) => {
  return (
    <El.Card>
      <El.Info>
        <El.Name>{name}</El.Name>
      </El.Info>
    </El.Card>
  )
}

export default Order;