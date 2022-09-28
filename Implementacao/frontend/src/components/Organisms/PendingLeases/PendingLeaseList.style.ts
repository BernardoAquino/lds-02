import styled from 'styled-components';

export const ErrorMessage = styled.p`
  color: ${(props) => props.theme.color.neutral[100]};
  font-size: ${(props) => props.theme.typography.fontSize[16]};
  font-weight: ${(props) => props.theme.typography.fontWeight.bold};
`