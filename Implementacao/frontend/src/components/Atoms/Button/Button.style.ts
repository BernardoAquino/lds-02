import styled from 'styled-components';

import { ButtonProps } from './';

const buttonColorMap = {
  'primary': 'brand',
  'secondary': 'brand',
}

export const Button = styled.button<ButtonProps>`
  outline: none;
  color: ${(props) => props?.theme?.color?.[buttonColorMap[props.color]]?.pure};
  background-color: ${(props) => props?.theme?.color?.[buttonColorMap[props.color]]?.light};
`