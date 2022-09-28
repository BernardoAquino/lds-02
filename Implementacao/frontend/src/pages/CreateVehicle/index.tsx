import React from 'react';

/** Components */
import CreateVehicle from '../../components/Organisms/CreateVehicle';
import AuthLayout from '../../layout/AuthLayout';

/** Style */
import * as El from './CreateVehicle.style';

const CreateVehiclePage = () => {
  return (
    <AuthLayout>
      <El.PageWrapper>
        <El.CardWrapper>
          <CreateVehicle />
        </El.CardWrapper>
      </El.PageWrapper>
    </AuthLayout>
  )
};

export default CreateVehiclePage;