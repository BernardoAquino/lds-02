import React from 'react';

/** Constants */
import { SIGNUP_URL } from '../../../constants';

/** Components */
import SignInForm from '../SignInForm';

/** Style */
import * as El from './SignIn.style';

const UserSignUp = () => {
  return (
    <El.Wrapper>
      <El.Title>Entre com suas credenciais</El.Title>
      <SignInForm onSubmit={console.log} />
      <El.DividerText>OU</El.DividerText>
      <El.CreateAgentAccountText href={SIGNUP_URL}>Crie uma conta de usuário</El.CreateAgentAccountText>
    </El.Wrapper>
  )
}

export default UserSignUp;
