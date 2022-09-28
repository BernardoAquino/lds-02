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
      name: 'nome',
      required: true
    },
    {
      type: 'email',
      label: 'Email',
      name: 'login',
      required: true
    },
    {
      type: 'password',
      label: 'Senha',
      name: 'senha',
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
      name: 'endereco',
      required: true
    },
    {
      type: 'text',
      label: 'Profissão',
      name: 'profissao',
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