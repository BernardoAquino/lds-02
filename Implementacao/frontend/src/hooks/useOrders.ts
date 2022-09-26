import { useEffect, useState } from 'react';

const MOCK_ORDERS = [
  {
    name: 'Pedido Chevette',
  },
  {
    name: 'Pedido Siena',
  }
]

const useOrders = () => {
  const [orders, setOrders] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  // const { authHeaders } = useSession();

  useEffect(() => {
    const getOrderData = async () => {
      // const requestResult = await fetch(`${process.env.API_BASE_URL}/pedidos`, { headers: authHeaders });

      // const result = await requestResult.json();

      // if (requestResult.status === 200) {
      //   setOrders(result);
      //   setIsLoading(false);
      //   setError(null);
      // }
      
      setOrders(MOCK_ORDERS)
      setIsLoading(false);
    }

    getOrderData();
  }, [])

  return {
    orders,
    isLoading,
    error
  }
}

export default useOrders;