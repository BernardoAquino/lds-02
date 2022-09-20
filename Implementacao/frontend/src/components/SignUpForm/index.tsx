import React from 'react';

import AgentSignUpForm from './AgentSignUpForm';
import UserSignUpForm from './UserSignUpForm';

type SignUpFormProps = {
  type: 'agent' | 'user';
  onSubmit: Function;
}

const SignUpForm = ({
  type,
  onSubmit
}: SignUpFormProps) => {
  const componentMap = {
    agent: AgentSignUpForm,
    user: UserSignUpForm
  }

  const Component = componentMap[type];

  return (
    <Component onSubmit={onSubmit} />
  )
}

export default SignUpForm;