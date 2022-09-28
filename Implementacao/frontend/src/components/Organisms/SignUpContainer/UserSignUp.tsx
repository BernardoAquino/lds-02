import React from 'react';
import { useNavigate } from 'react-router-dom';

/** Constants */
import { AGENT_SIGNUP_URL, SIGNIN_URL } from '../../../constants';

/** Types */
import { Form } from '../../../hooks/useForm';

/** Hooks */
import { UserData, useSignUpUser } from '../../../hooks/useSignUp';

/** Components */
import SignUpForm from '../SignUpForm';

/** Style */
import * as El from './SignUpContainer.style';

const UserSignUp = () => {
  const navigate = useNavigate();
  const { signUp } = useSignUpUser();

  const handleSubmit = (formValues: Form) => {
    signUp(formValues as UserData).then(response => {
      if (response.userCreatedSuccessfully) {
        navigate(SIGNIN_URL);
      }
    });
  }

  return (
    <El.Wrapper>
      <El.Title>Crie sua conta de usuário</El.Title>
      <SignUpForm type={'user'} onSubmit={handleSubmit} />
      <El.AlreadyHasAccount>Já possui conta? <a href={SIGNIN_URL}>Clique aqui para entrar</a></El.AlreadyHasAccount>
      <El.DividerText>OU</El.DividerText>
      <El.CreateAgentAccountText href={AGENT_SIGNUP_URL}>Crie uma conta de empresa ou banco</El.CreateAgentAccountText>
    </El.Wrapper>
  )
}

export default UserSignUp;
