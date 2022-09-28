import { toast } from "react-toastify";

/** Hooks */
import { useSession } from "../providers/Auth";

export type VehicleData = {
  ano: string;
  marca: string;
  modelo: string;
  placa: string;
  analistaId?: string | undefined;
}

type EditVehicleData = VehicleData & {
  matricula: number;
}

type CreateVehicleResponse = {
  vehicleCreatedSuccessfully: boolean;
  error: boolean;
}

type EditVehicleResponse = {
  vehicleEditedSuccessfully: boolean;
  error: boolean;
}

type GetVehicleResponse = {
  vehicle: VehicleData | null;
  error: boolean;
}

export const useVehicle = () => {
  const { session } = useSession();

  const getVehicle = async (vehicleId: number): Promise<GetVehicleResponse> =>  {
    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/${vehicleId}`, {
      headers: session.authHeaders
    });

    const responseBody = await response.json();
    const vehicleFoundSuccessfully = response.status === 200;
    let vehicle = null;

    if (vehicleFoundSuccessfully) {
      vehicle = {
        ano: responseBody.ano,
        marca: responseBody.marca,
        modelo: responseBody.modelo,
        placa: responseBody.placa,
        analistaId: responseBody.analista.id,
      }
    }

    return {
      vehicle,
      error: !vehicleFoundSuccessfully,
    }
  }

  const createVehicle = async (vehicle: VehicleData): Promise<CreateVehicleResponse> => {
    const vehicleData = vehicle?.analistaId ? { ...vehicle, analistaId: Number(vehicle.analistaId) } : vehicle;

    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/novo`, {
      method: 'POST',
      body: JSON.stringify({
        ...vehicleData
      }),
      headers: session.authHeaders
    });

    const vehicleCreatedSuccessfully = response.status === 201;

    return {
      vehicleCreatedSuccessfully,
      error: !vehicleCreatedSuccessfully
    }
  }

  const editVehicle = async (vehicle: EditVehicleData): Promise<EditVehicleResponse> => {
    const vehicleData = vehicle?.analistaId ? { ...vehicle, analistaId: Number(vehicle.analistaId) } : vehicle;

    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/automovel/${vehicleData.matricula}`, {
      method: 'PUT',
      body: JSON.stringify({
        ...vehicleData
      }),
      headers: session.authHeaders
    });

    const vehicleEditedSuccessfully = response.status === 200;

    if (vehicleEditedSuccessfully) {
      toast.success("Veículo salvo com sucesso!");
    }

    return {
      vehicleEditedSuccessfully,
      error: !vehicleEditedSuccessfully
    }
  }

  

  return { 
    createVehicle,
    editVehicle,
    getVehicle
  };
}