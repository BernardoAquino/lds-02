import React from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { CREATE_CAR_URL } from '../../constants';

/** Components */
import VehicleList from '../../components/Organisms/VehicleList';
import Button from '../../components/Atoms/Button';

/** Layout */
import AuthLayout from '../../layout/AuthLayout';

const ListVehicles = () => {
  const navigate = useNavigate();

  const goToCreateVehicle = () => {
    navigate(CREATE_CAR_URL)
  }

  return (
    <AuthLayout>
      <Button onClick={goToCreateVehicle}>Novo</Button>
      <VehicleList />
    </AuthLayout>
  )
}

export default ListVehicles;
