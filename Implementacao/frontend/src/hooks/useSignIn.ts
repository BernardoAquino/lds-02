type UserCredentials = {
  email: string;
  password: string;
}

type UserSignInResponse = {
  error?: boolean;
  user?: Object;
}

const useSignIn = () => {
  const signIn = async (user: UserCredentials): Promise<UserSignInResponse | void> => {
    const response = await fetch(`${process.env.API_BASE_URL}/signIn`, {
      method: 'POST',
      body: JSON.stringify({
        ...user
      })
    });

    const responseBody = await response.json();

    return {
      user: responseBody,
      error: response.status !== 200
    }
  }

  return { 
    signIn
  };
};