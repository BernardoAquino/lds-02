import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { PENDING_LEASES_URL } from '../../constants';

/** Components */
import AvailableVehiclesList from '../../components/Organisms/AvailableVehiclesList';

/** Layout */
import AuthLayout from '../../layout/AuthLayout';

/** Hooks */
import { useSession } from '../../providers/Auth';

const ListAvailableVehicles = () => {
  const navigate = useNavigate();
  const { session } = useSession();

  useEffect(() => {
    if (session.isAgent) {
      navigate(PENDING_LEASES_URL)
    }
  }, [session])

  return (
    <AuthLayout>
      <AvailableVehiclesList />
    </AuthLayout>
  )
}

export default ListAvailableVehicles;
