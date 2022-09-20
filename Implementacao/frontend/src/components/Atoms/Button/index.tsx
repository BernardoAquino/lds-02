import React, { MouseEventHandler } from 'react';

import * as El from './Button.style';

export type ButtonProps = {
  children: React.ReactElement | string;
  color: 'primary' | 'secondary';
  disabled?: boolean;
  onClick?: (MouseEventHandler<HTMLButtonElement> & Function) | undefined;
  type?: 'button' | 'submit' | 'reset' | undefined;
}

const Button = ({
  children,
  color,
  disabled = false,
  onClick,
  type = 'button',
}: ButtonProps) => {
  return (
    <El.Button color={color} type={type} disabled={disabled} onClick={onClick}>
      {children}
    </El.Button>
  )
}

export default Button;
