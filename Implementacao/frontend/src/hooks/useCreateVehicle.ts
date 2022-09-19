type UseCreateVehicleParams = {
  agentId: string;
}

type VehicleData = {
  registration: string;
  year: string;
  brand: string;
  model: string;
  plateNumber: string;
}

type CreateVehicleResponse = {
  vehicleCreatedSuccessfully: boolean;
  error: boolean;
}

export const useCreateVehicle = ({ agentId }: UseCreateVehicleParams) => {
  const createVehicle = async (vehicle: VehicleData): Promise<CreateVehicleResponse> => {
    const response = await fetch(`${process.env.API_BASE_URL}/vehicle`, {
      method: 'POST',
      body: JSON.stringify({
        ...vehicle,
        agentId
      })
    });

    const responseBody = await response.json();

    return {
      vehicleCreatedSuccessfully: responseBody.vehicleCreatedSuccessfully,
      error: response.status !== 200
    }
  }

  return { createVehicle };
}