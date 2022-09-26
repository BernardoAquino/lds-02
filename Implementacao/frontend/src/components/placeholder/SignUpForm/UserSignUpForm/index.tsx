import React from 'react';

/** Types */
import { Field } from '../../../../hooks/useForm';

/** Components */
import Form from '../../../Molecules/Form';

type UserSignUpFormProps = {
  onSubmit: Function;
};

const UserSignUpForm = ({ onSubmit }: UserSignUpFormProps) => {
  const userSignUpFormFields: Field[] = [
    {
      type: 'text',
      label: 'Nome',
      name: 'name',
      required: true
    },
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
    {
      type: 'text',
      label: 'RG',
      name: 'rg',
      required: true
    },
    {
      type: 'text',
      label: 'CPF',
      name: 'cpf',
      required: true
    },
    {
      type: 'text',
      label: 'Endereco',
      name: 'address',
      required: true
    },
  ]

  return (
    <Form
      onSubmit={onSubmit}
      fields={userSignUpFormFields}
      submitLabel={'Finalizar cadastro'}
    />
  );
};

export default UserSignUpForm;