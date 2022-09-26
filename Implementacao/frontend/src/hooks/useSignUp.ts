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
  const signUp = async (user: UserData): Promise<SignUpResponse | void> => {
    const response = await fetch(`${process.env.API_BASE_URL}/signUp/user`, {
      method: 'POST',
      body: JSON.stringify({
        ...user
      })
    });

    const responseBody = await response.json();

    return {
      userCreatedSuccessfully: responseBody.userCreatedSuccessfully,
      error: response.status !== 200
    }
  }

  return { 
    signUp
  };
};

export type AgentData = {
  email: string;
  password: string;
}

export const useSignUpAgent = () => {
  const signUp = async (agent: AgentData): Promise<SignUpResponse | void> => {
    const response = await fetch(`${process.env.API_BASE_URL}/signUp/agent`, {
      method: 'POST',
      body: JSON.stringify({
        ...agent
      })
    });

    const responseBody = await response.json();

    return {
      userCreatedSuccessfully: responseBody.agentCreatedSuccessfully,
      error: response.status !== 200
    }
  }

  return { 
    signUp
  };
};