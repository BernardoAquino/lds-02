import React from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { LIST_CARS_URL, RENT_URL_BASE, SIGNUP_URL } from '../../../constants';
import { Form } from '../../../hooks/useForm';
import useSignIn, { UserCredentials } from '../../../hooks/useSignIn';

/** Components */
import SignInForm from '../SignInForm';

/** Style */
import * as El from './SignIn.style';

const UserSignUp = () => {
  const navigate = useNavigate();
  const { signIn } = useSignIn();

  const handleSubmit = (formValues: Form) => {
    signIn(formValues as UserCredentials).then(response => {
      if (!response.error) {
        const URL = response.isAgent ? LIST_CARS_URL : RENT_URL_BASE

        navigate(URL);
      }
    });
  }

  return (
    <El.Wrapper>
      <El.Title>Entre com suas credenciais</El.Title>
      <SignInForm onSubmit={handleSubmit} />
      <El.DividerText>OU</El.DividerText>
      <El.CreateAgentAccountText href={SIGNUP_URL}>Crie uma conta de usuário</El.CreateAgentAccountText>
    </El.Wrapper>
  )
}

export default UserSignUp;
