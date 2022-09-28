import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { useSession } from '../providers/Auth';

const useVehicleList = <T>() => {
  const [vehicles, setVehicles] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<boolean>(false);

  const { session } = useSession();

  const getVehicleData = async () => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/disponiveis`, { headers: session.authHeaders });

    const result = await requestResult.json();

    if (requestResult.status === 200) {
      const vehicles = result.map((vehicle: any) => ({
        name: `${vehicle.marca} ${vehicle.modelo}`,
        owner: vehicle.proprietario.nome,
        id: vehicle.matricula,
      }))

      setVehicles(vehicles);
      setError(false);
    } else {
      setError(true);
    }
    

    setIsLoading(false);
  }

  useEffect(() => {
    getVehicleData();
  }, [])

  const createLease = async (vehicleId: number) => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/pedido/criar/${vehicleId}`, {
      method: 'POST',
      headers: session.authHeaders
    });

    if (requestResult.status === 201) {
      toast.success('Pedido criado com sucesso!');
    } else {
      toast.error('Ocorreu um erro ao criar o pedido');
    }

    getVehicleData();
  }

  return {
    vehicles,
    isLoading,
    error,
    createLease
  }
}

export default useVehicleList;