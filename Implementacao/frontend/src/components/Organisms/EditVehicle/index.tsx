import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { LIST_CARS_URL } from '../../../constants';
import { useVehicle, VehicleData } from '../../../hooks/useVehicle';

/** Hooks */
import { Form } from '../../../hooks/useForm';

/** Components */
import VehicleForm from '../VehicleForm';

/** Style */
import * as El from './EditVehicle.style';
import KeyValuePair from '../../../types/KeyValuePair';

type EditVehicleProps = {
  vehicleId: number
}

const EditVehicle = ({
  vehicleId
}: EditVehicleProps) => {
  const navigate = useNavigate();
  const { editVehicle, getVehicle } = useVehicle();
  const [vehicleDefaultValues, setVehicleDefaultValues] = useState<KeyValuePair<string>>();

  useEffect(() => {
    getVehicle(vehicleId).then(response => {
      if (!response.error && response.vehicle) {
        setVehicleDefaultValues(response.vehicle)
      }
    })
  }, []);

  const handleSubmit = (formValues: Form) => {
    const values = {
      ...formValues as VehicleData,
      matricula: vehicleId
    }

    editVehicle(values).then(response => {
      if (!response.error) {
        navigate(LIST_CARS_URL);
      }
    });
  }

  return (
    <El.Wrapper>
      <El.Title>Editar veiculo</El.Title>
      <VehicleForm 
        onSubmit={handleSubmit} 
        submitLabel={'Salvar alterações'} 
        values={vehicleDefaultValues}
      />
    </El.Wrapper>
  )
}

export default EditVehicle;
