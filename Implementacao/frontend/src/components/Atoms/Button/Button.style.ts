import styled from 'styled-components';

import { ButtonProps } from './';

export const Button = styled.button<ButtonProps>`
  outline: none;
  color: ${(props) => props.theme.colors[props.color].pure};
  background-color: ${(props) => props.theme.colors[props.color].light};
`