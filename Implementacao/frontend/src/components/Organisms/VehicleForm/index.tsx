import React from 'react';

/** Types */
import { Field } from '../../../hooks/useForm';
import KeyValuePair from '../../../types/KeyValuePair';

/** Hooks */
import useAgents from '../../../hooks/useAgents';
import { useSession } from '../../../providers/Auth';

/** Components */
import Form from '../../Molecules/Form';

type VehicleFormProps = {
  onSubmit: Function;
  submitLabel: string
  values?: KeyValuePair<string>
};

const VehicleForm = ({ onSubmit, submitLabel, values }: VehicleFormProps) => {
  const { session } = useSession();
  const { agents } = useAgents(session?.isAgent);

  let vehicleFormFields: Field[] = [
    {
      type: 'text',
      label: 'Ano',
      name: 'ano',
      value:  values?.ano,
      required: true
    },
    {
      type: 'text',
      label: 'Marca',
      name: 'marca',
      value:  values?.marca,
      required: true
    },
    {
      type: 'text',
      label: 'Modelo',
      name: 'modelo',
      value:  values?.modelo,
      required: true
    },
    {
      type: 'text',
      label: 'Placa',
      name: 'placa',
      value:  values?.placa,
      required: true
    },
  ]

  if (!session.isAgent) {
    vehicleFormFields = [
      ...vehicleFormFields,
      {
        type: 'select',
        label: 'Agente responsável',
        name: 'analistaId',
        value:  values?.analistaId,
        options: agents.map((agent: any) => ({
          label: agent.name,
          value: agent.id
        }))
      },
    ]
  }

  return (
    <Form
      onSubmit={onSubmit}
      fields={vehicleFormFields}
      submitLabel={submitLabel}
    />
  );
};

export default VehicleForm;