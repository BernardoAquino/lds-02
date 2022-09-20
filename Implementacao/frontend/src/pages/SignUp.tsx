import React from 'react';

/** Components */
import SignUpForm from '../components/organisms/SignUpForm';

const SignUp = () => {
  return (
    <>
      <p>Cadastre-se</p>
      <SignUpForm type={'user'} onSubmit={console.log} />
    </>
  )
};

export default SignUp;