import React from 'react';

/** Types */
import { Field } from '../../../hooks/useForm';

/** Components */
import Form from '../../molecules/Form';

type SignInFormProps = {
  onSubmit: Function;
};

const SignInForm = ({ onSubmit }: SignInFormProps) => {
  const signIpFormFields: Field[] = [
    {
      type: 'email',
      label: 'Email',
      name: 'email',
      required: true
    },
    {
      type: 'password',
      label: 'Senha',
      name: 'password',
      required: true
    },
  ]

  return (
    <Form
      onSubmit={onSubmit}
      fields={signIpFormFields}
      submitLabel={'Entrar'}
    />
  );
};

export default SignInForm;