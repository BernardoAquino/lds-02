import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

/** Hooks */
import { useSession } from '../providers/Auth';

export type PendingLease = {
  id: number;
  vehicle: string;
  client: string;
  owner: string;
}

const useLeases = () => {
  const [leases, setLeases] = useState<PendingLease[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(false);

  const { session } = useSession();

  const getPendingLeases = async () => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/pedido/pendentes`, { headers: session.authHeaders });

    const result = await requestResult.json();

    if (requestResult.status === 200) {
      const leases = result.map((lease: any) => ({
        id: lease.id,
        vehicle: `${lease.automovel.marca} ${lease.automovel.modelo}`,
        client: lease.contratante.nome,
        owner: lease.automovel.proprietario.nome,
      }))

      setLeases(leases);
      setError(false);
    } else {
      setError(true);
    }
    
    setIsLoading(false);
  }

  useEffect(() => {
    getPendingLeases();
  }, [])

  const cancelLease = async (leaseId: number) => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/pedido/cancelar/${leaseId}`, { 
      method: 'DELETE',
      headers: session.authHeaders 
    });

    if (requestResult.status === 204) {
      toast.success('Pedido cancelado com sucesso!');
    } else {
      toast.error(`Ocorreu um erro ao cancelar o pedido`);
    }

    getPendingLeases();
  }

  const validateLease = async (leaseId: number, approvedLease: boolean, hasCreditContract: boolean = false) => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/pedido/avaliar/${leaseId}`, { 
      method: 'PUT',
      body: JSON.stringify({
        contratoCredito: hasCreditContract,
        parecerDoAgente: approvedLease
      }),
      headers: session.authHeaders 
    });

    if (requestResult.status === 200) {
      toast.success('Pedido avaliado com sucesso!');
    } else {
      toast.error(`Ocorreu um erro ao avaliar o pedido`);
    }

    getPendingLeases();
  }

  return {
    leases,
    isLoading,
    error,
    cancelLease,
    validateLease
  }
}

export default useLeases;