import React from 'react';
import SignUpForm from '../components/SignUpForm';

const SignUp = () => {
  return (
    <>
      <p>Cadastre-se</p>
      <SignUpForm type={'user'} onSubmit={console.log} />
    </>
  )
};

export default SignUp;