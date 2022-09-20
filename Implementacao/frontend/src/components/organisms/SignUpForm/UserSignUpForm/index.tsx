import React from 'react';

/** Types */
import { Field } from '../../../../hooks/useForm';

/** Components */
import Form from '../../../molecules/Form';

type UserSignUpFormProps = {
  onSubmit: Function;
};

const UserSignUpForm = ({ onSubmit }: UserSignUpFormProps) => {
  const userSignUpFormFields: Field[] = [
    {
      type: 'text',
      label: 'Nome',
      name: 'name',
    },
    {
      type: 'email',
      label: 'Email',
      name: 'email',
    },
    {
      type: 'password',
      label: 'Senha',
      name: 'password',
    },
    {
      type: 'text',
      label: 'RG',
      name: 'rg',
    },
    {
      type: 'text',
      label: 'CPF',
      name: 'cpf',
    },
    {
      type: 'text',
      label: 'Endereco',
      name: 'address',
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