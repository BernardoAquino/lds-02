import { useEffect, useState } from 'react';
import { useSession } from '../providers/Auth';

const useAgents = (skip: boolean = false) => {
  const [agents, setAgents] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<boolean>(false);

  const { session } = useSession();

  const getAgentsData = async () => {
    const requestResult = await fetch(`${process.env.REACT_APP_API_BASE_URL}/agente/all`, { headers: session.authHeaders });

    const result = await requestResult.json();

    if (requestResult.status === 200) {
      const agents = result.map((agent: any) => ({
        name: agent.nome,
        id: agent.id,
      }))

      setAgents(agents);
      setError(false);
    } else {
      setError(true);
    }
    

    setIsLoading(false);
  }

  useEffect(() => {
    if (skip) {
      getAgentsData();
    }
  }, [])

  return {
    agents,
    isLoading,
    error,
  }
}

export default useAgents;