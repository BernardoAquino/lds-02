import React, { ChangeEventHandler, FocusEventHandler } from 'react';

import * as El from './TextField.style';

type TextFieldProps = {
  label?: string;
  value?: string;
  placeholder?: string
  onChange?: ChangeEventHandler<HTMLInputElement> | undefined;
  onBlur?: FocusEventHandler<HTMLInputElement> | undefined;
}

const TextField = ({
  label,
  value,
  placeholder,
  onChange,
  onBlur,
}: TextFieldProps) => {
  return (
    <>
      <El.Label>{label}</El.Label>
      <El.TextField 
        type={'text'} 
        value={value} 
        placeholder={placeholder} 
        onChange={onChange} 
        onBlur={onBlur} 
      />
    </>
  )
}

export default TextField;