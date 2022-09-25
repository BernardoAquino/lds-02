import React from 'react';

/** Constants */
import { AGENT_SIGNUP_URL } from '../../../constants';

/** Components */
import SignUpForm from '../SignUpForm';

/** Style */
import * as El from './SignUpContainer.style';

const UserSignUp = () => {
  return (
    <El.Wrapper>
      <El.Title>Crie sua conta de usuário</El.Title>
      <SignUpForm type={'user'} onSubmit={console.log} />
      <El.DividerText>OU</El.DividerText>
      <El.CreateAgentAccountText href={AGENT_SIGNUP_URL}>Crie uma conta de empresa ou banco</El.CreateAgentAccountText>
    </El.Wrapper>
  )
}

export default UserSignUp;
