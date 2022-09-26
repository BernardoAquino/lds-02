import React from 'react';

/** Constants */
import { SIGNIN_URL, SIGNUP_URL } from '../../../constants';

/** Types */
import { Form } from '../../../hooks/useForm';

/** Hooks */
import { AgentData, useSignUpAgent } from '../../../hooks/useSignUp';

/** Components */
import SignUpForm from '../SignUpForm';

/** Style */
import * as El from './SignUpContainer.style';

const AgentSignUp = () => {
  const { signUp } = useSignUpAgent();

  const handleSubmit = (formValues: Form) => {
    signUp(formValues as AgentData);
  }

  return (
    <El.Wrapper>
      <El.Title>Crie sua conta de agente</El.Title>
      <SignUpForm type={'agent'} onSubmit={handleSubmit} />
      <El.AlreadyHasAccount>Já possui conta? <a href={SIGNIN_URL}>Clique aqui para entrar</a></El.AlreadyHasAccount>
      <El.DividerText>OU</El.DividerText>
      <El.CreateAgentAccountText href={SIGNUP_URL}>Crie uma conta de cliente</El.CreateAgentAccountText>
    </El.Wrapper>
  )
}

export default AgentSignUp;
