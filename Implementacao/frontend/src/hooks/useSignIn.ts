import { toast } from "react-toastify";
import { useSession } from "../providers/Auth";

export type UserCredentials = {
  email: string;
  senha: string;
}

type UserSignInResponse = {
  isAgent?: boolean;
  error?: boolean;
  errorMessage?: string;
  user?: Object;
}

const useSignIn = () => {
  const { updateSession } = useSession();

  const signIn = async (user: UserCredentials): Promise<UserSignInResponse> => {
    const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/usuario/autenticar`, {
      method: 'POST',
      body: JSON.stringify({
        ...user
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    });

    let responseBody: any = null;
    const successfullyLoggedIn = response.status === 200
    const unauthorized = response.status === 401

    if (unauthorized) {
      toast.error("Login e/ou senha incorretos");
    } else if (successfullyLoggedIn) {
      const responseBody = await response.json();

      updateSession({
        name: responseBody.nome,
        token: responseBody.hash,
        isAgent: Object.hasOwn(responseBody, 'tipoAgente')
      });
    }

    return {
      isAgent: successfullyLoggedIn && Object.hasOwn(responseBody, 'tipoAgente'),
      user: successfullyLoggedIn && responseBody,
      error: !successfullyLoggedIn,
      errorMessage: !successfullyLoggedIn && responseBody
    }
  }

  return { 
    signIn
  };
};

export default useSignIn;