import React from 'react';

type AgentSignUpFormProps = {
  onSubmit: Function;
};

const AgentSignUpForm = ({ onSubmit }: AgentSignUpFormProps) => {
  return (
    <form onSubmit={() => onSubmit()}>
    </form>
  );
};

export default AgentSignUpForm;