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
      name: 'agent_type',
      options: [
        {
          label: 'Banco',
          value: 'banco',
        },
        {
          label: 'Empresa',
          value: 'empresa',
        }
      ]
    },
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
      label: 'Endereco',
      name: 'address',
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