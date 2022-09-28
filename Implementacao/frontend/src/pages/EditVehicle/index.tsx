import React from 'react';
import { useParams } from 'react-router-dom';

/** Components */
import EditVehicle from '../../components/Organisms/EditVehicle';

/** Layout */
import AuthLayout from '../../layout/AuthLayout';

/** Style */
import * as El from './EditVehicle.style';

const EditVehiclePage = () => {
  const { id: vehicleId } = useParams();

  return (
    <AuthLayout>
      <El.PageWrapper>
        <El.CardWrapper>
          <EditVehicle vehicleId={Number(vehicleId)} />
        </El.CardWrapper>
      </El.PageWrapper>
    </AuthLayout>
  )
};

export default EditVehiclePage;