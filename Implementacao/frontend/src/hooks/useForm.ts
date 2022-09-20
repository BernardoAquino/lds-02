import { useState } from "react";

export type Field = {
  type: 'text' | 'password' | 'email';
  name: string;
  label: string;
};

type Form = {
  [key: string]: string | null;
};

const createDefaultForm = (fields: Field[]): Form => fields.reduce((formObject, field) => {
  formObject[field.type] = null;

  return formObject;
}, {} as Form);

const useForm = (fields: Field[]) => {
  const DEFAULT_FORM = createDefaultForm(fields);
  const [form, setForm] = useState<Form>(DEFAULT_FORM);
  const [isSubmittingForm, setIsSubmittingForm] = useState(false);

  const updateFormField = (field: Field, value: string) => {
    setForm((prevForm) => ({
      ...prevForm,
      [field.name]: value,
    }))
  }

  const handleSubmit = (callback: Function) => () => {
    setIsSubmittingForm(true);
    callback?.(form);
    setIsSubmittingForm(false);
  }

  return {
    updateFormField,
    handleSubmit,
    isSubmittingForm
  };
};

export default useForm;