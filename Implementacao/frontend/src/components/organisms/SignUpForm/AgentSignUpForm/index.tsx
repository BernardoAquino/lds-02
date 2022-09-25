import React from 'react';

/** Types */
import { Field } from '../../../../hooks/useForm';

/** Components */
import Form from '../../../molecules/Form';

type AgentSignUpFormProps = {
  onSubmit: Function;
};

const AgentSignUpForm = ({ onSubmit }: AgentSignUpFormProps) => {
  const agentSignUpFormFields: Field[] = [
    // {
    //   type: 'select',
    //   label: 'Tipo de agente',
    //   options: [
    //     {
    //       name: 'Banco',
    //       value: 'banco',
    //     },
    //     {
    //       name: 'Empresa',
    //       value: 'empresa',
    //     }
    //   ]
    // },
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
      label: 'Endereco',
      name: 'address',
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