import React from 'react';

/** Hooks */
import useForm, { Field } from '../../../hooks/useForm';
import KeyValuePair from '../../../types/KeyValuePair';

/** Component */
import Button from '../../atoms/Button';
import TextField from '../../atoms/FormField/TextField';

/** Styles */
import * as El from './Form.style';

type FormProps = {
  fields: Field[];
  submitLabel?: string;
  onSubmit: Function;
}

const componentMap = {
  text: TextField,
  password: TextField,
  email: TextField,
}

const Form = ({
  submitLabel = 'enviar',
  fields,
  onSubmit
}: FormProps) => {
  const { updateFormField, isSubmittingForm, handleSubmit } = useForm(fields);

  const onChangeMap: KeyValuePair<(field: Field) => (e: React.ChangeEvent<HTMLInputElement>) => void> = {
    default: (field: Field) => (e: React.ChangeEvent<HTMLInputElement>) => updateFormField(field, e.target.value)
  }

  const getChangeMapType = (type: string) => {
    if (Object.hasOwn(onChangeMap, type)) {
      return type;
    }

    return 'default';
  }

  const renderField = (field: Field) => {
    const { type, ...fieldProps } = field;

    const Component = componentMap[type];
    const onChangeCb = onChangeMap?.[getChangeMapType(type)]?.(field);

    console.log('type: ', type, fieldProps);

    return <Component {...fieldProps} onChange={onChangeCb} />
  }

  return (
    <El.Form onSubmit={handleSubmit(onSubmit)}>
      {fields.map(renderField)}

      <Button color='primary' disabled={isSubmittingForm}>
        {submitLabel}
      </Button>
    </El.Form>
  )
}

export default Form;