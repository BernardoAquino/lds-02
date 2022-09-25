import React from 'react';

/** Hooks */
import useForm, { Field } from '../../../hooks/useForm';
import KeyValuePair from '../../../types/KeyValuePair';

/** Component */
import Button from '../../Atoms/Button';
import TextField from '../../Atoms/FormField/TextField';

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
    const normalizedFieldName = fieldProps.name.toLowerCase().split(' ').join('_');

    const Component = componentMap[type];
    const onChangeCb = onChangeMap?.[getChangeMapType(type)]?.(field);
    const key = `form-field-${normalizedFieldName}`

    return <Component key={key} {...fieldProps} type={type} onChange={onChangeCb} />
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
