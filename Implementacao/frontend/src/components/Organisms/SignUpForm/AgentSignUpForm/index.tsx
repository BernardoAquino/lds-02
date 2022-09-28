import React from 'react';

/** Types */
import { Field } from '../../../../hooks/useForm';

/** Components */
import Form from '../../../Molecules/Form';

type AgentSignUpFormProps = {
  onSubmit: Function;
};

const AgentSignUpForm = ({ onSubmit }: AgentSignUpFormProps) => {
  const agentSignUpFormFields: Field[] = [
    {
      type: 'select',
      label: 'Tipo de agente',
      name: 'tipoAgente',
      value: '',
      options: [
        {
          label: 'Banco',
          value: 'BANCO',
        },
        {
          label: 'Empresa',
          value: 'EMPRESA',
        }
      ]
    },
    {
      type: 'text',
      label: 'CNPJ',
      name: 'cnpj',
      value: '',
      required: true
    },
    {
      type: 'text',
      label: 'Nome',
      name: 'nome',
      value: '',
      required: true
    },
    {
      type: 'email',
      label: 'Email',
      name: 'login',
      value: '',
      required: true
    },
    {
      type: 'password',
      label: 'Senha',
      name: 'senha',
      value: '',
      required: true
    },
  ]

  return (
    <Form
      onSubmit={onSubmit}
      fields={agentSignUpFormFields}
      submitLabel={'Finalizar cadastro'}
    />
  );
};

export default AgentSignUpForm;