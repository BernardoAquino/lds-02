import React from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { LIST_CARS_URL } from '../../../constants';
import { useVehicle, VehicleData } from '../../../hooks/useVehicle';

/** Hooks */
import { Form } from '../../../hooks/useForm';

/** Components */
import CreateVehicleForm from '../VehicleForm';

/** Style */
import * as El from './CreateVehicle.style';

const CreateVehicle = () => {
  const navigate = useNavigate();
  const { createVehicle } = useVehicle();

  const handleSubmit = (formValues: Form) => {
    createVehicle(formValues as VehicleData).then(response => {
      if (!response.error) {
        navigate(LIST_CARS_URL);
      }
    });
  }

  return (
    <El.Wrapper>
      <El.Title>Criar veiculo</El.Title>
      <CreateVehicleForm onSubmit={handleSubmit} submitLabel={'Criar'} />
    </El.Wrapper>
  )
}

export default CreateVehicle;
