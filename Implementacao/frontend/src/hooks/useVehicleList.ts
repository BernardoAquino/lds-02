import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { useSession } from '../providers/Auth';

const useVehicleList = <T>() => {
  const [vehicles, setVehicles] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<boolean>(false);

  const { session } = useSession();

  const getVehicleData = async () => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/meus`, { headers: session.authHeaders });

    const result = await requestResult.json();

    if (requestResult.status === 200) {
      const vehicles = result.map((vehicle: any) => ({
        name: `${vehicle.marca} ${vehicle.modelo}`,
        isLeased: vehicle.isAlugado,
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

  const deleteVehicle = async (vehicle: T | any) => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/${vehicle.id}`, {
      method: 'DELETE',
      headers: session.authHeaders
    });

    if (requestResult.status === 204) {
      toast.success(`${vehicle.name} deletado com sucesso!`);
    } else {
      toast.error(`Ocorreu um erro ao deletar ${vehicle.name}`);
    }

    getVehicleData();
  }

  return {
    vehicles,
    isLoading,
    error,
    deleteVehicle
  }
}

export default useVehicleList;