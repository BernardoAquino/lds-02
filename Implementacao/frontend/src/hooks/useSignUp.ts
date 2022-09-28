import { toast } from 'react-toastify';

type UserAddress = {
  street: string;
  neighbourhood: string;
  zipCode: string;
  state: string;
}

export type UserData = {
  name: string;
  email: string;
  rg: string;
  cpf: string;
  address: string;
}

type SignUpResponse = {
  error?: boolean;
  userCreatedSuccessfully?: boolean;
}

export const useSignUpUser = () => {
  const signUp = async (user: UserData): Promise<SignUpResponse> => {
    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/contratante/novo`, {
      method: 'POST',
      body: JSON.stringify({
        ...user
      }),
      headers: {
        'Content-Type': 'application/json'
      }
    });

    const userCreatedSuccessfully = response.status === 201;
    
    if (userCreatedSuccessfully) {
      toast.success("Usuário criado com sucesso!");
    } else {
      const errorMessage = await response.json();

      toast.error(errorMessage);
    }

    return {
      userCreatedSuccessfully,
      error: !userCreatedSuccessfully,
    }
  }

  return { 
    signUp
  };
};

export type AgentData = {
  nome: string;
  login: string;
  senha: string;
  tipoAgente: string;
  cnpj: string;
}

export const useSignUpAgent = () => {
  const signUp = async (agent: AgentData): Promise<SignUpResponse | void> => {
    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/agente/novo`, {
      method: 'POST',
      body: JSON.stringify({
        ...agent
      }),
      headers: {
        'Content-Type': 'application/json'
      }
    });

    const userCreatedSuccessfully = response.status === 201;
    
    if (userCreatedSuccessfully) {
      toast.success("Usuário criado com sucesso!");
    } else {
      const errorMessage = await response.json();

      toast.error(errorMessage);
    }

    return {
      userCreatedSuccessfully,
      error: !userCreatedSuccessfully,
    }
  }

  return { 
    signUp
  };
};