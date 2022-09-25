import React, { ChangeEventHandler, FocusEventHandler } from 'react';

import * as El from './TextField.style';

type TextFieldProps = {
  type: 'text' | 'password' | 'email';
  name: string;
  label?: string;
  value?: string;
  placeholder?: string
  onChange?: ChangeEventHandler<HTMLInputElement> | undefined;
  onBlur?: FocusEventHandler<HTMLInputElement> | undefined;
}

const TextField = ({
  type,
  name,
  label,
  value,
  placeholder,
  onChange,
  onBlur,
}: TextFieldProps) => {
  return (
    <El.Container>
      <El.Label htmlFor={name}>{label}</El.Label>
      <El.TextField 
        type={type} 
        name={name}
        value={value} 
        placeholder={placeholder} 
        onChange={onChange} 
        onBlur={onBlur} 
      />
    </El.Container>
  )
}

export default TextField;