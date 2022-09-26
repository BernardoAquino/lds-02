import { useEffect, useState } from 'react';

const MOCK_VEHICLES = [
  {
    name: 'Chevette',
    isLeased: true
  },
  {
    name: 'Siena',
    isLeased: false
  }
]

const useVehicles = () => {
  const [vehicles, setVehicles] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  // const { authHeaders } = useSession();

  useEffect(() => {
    const getVehicleData = async () => {
      // const requestResult = await fetch(`${process.env.API_BASE_URL}/veiculos`, { headers: authHeaders });

      // const result = await requestResult.json();

      // if (requestResult.status === 200) {
      //   setVehicles(result);
      //   setIsLoading(false);
      //   setError(null);
      // }
      
      setVehicles(MOCK_VEHICLES)
      setIsLoading(false);
    }

    getVehicleData();
  }, [])

  return {
    vehicles,
    isLoading,
    error
  }
}

export default useVehicles;