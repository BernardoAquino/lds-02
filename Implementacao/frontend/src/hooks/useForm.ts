import { FormEvent, useState } from "react";
import { Option as SelectOption } from "../components/Atoms/FormField/Select";



export type Field = {
  type: 'text' | 'password' | 'email' | 'select';
  name: string;
  label: string;
  required?: boolean;
  options?: SelectOption[]
};

type Form = {
  [key: string]: string | null;
};

const createDefaultForm = (fields: Field[]): Form => fields.reduce((formObject, field) => {
  formObject[field.name] = null;

  return formObject;
}, {} as Form);

const useForm = (fields: Field[]) => {
  const DEFAULT_FORM = createDefaultForm(fields);
  const [form, setForm] = useState<Form>(DEFAULT_FORM);
  const [isSubmittingForm, setIsSubmittingForm] = useState(false);

  const updateFormField = (field: Field, value: any) => {
    console.log('UPDATING FIELD', field, value)
    setForm((prevForm) => ({
      ...prevForm,
      [field.name]: value,
    }))
  }

  const handleSubmit = (callback: Function) => (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setIsSubmittingForm(true);
    console.log('IS SUBMITTING!!!!!!', form)
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