import React from 'react';

/** Components */
import AuthLayout from '../../layout/AuthLayout';
import VehicleList from '../../components/Organisms/VehicleList';

const ListVehicles = () => {
  return (
    <AuthLayout>
      <VehicleList />
    </AuthLayout>
  )
}

export default ListVehicles;
