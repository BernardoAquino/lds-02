import styled from 'styled-components';

export const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`

export const Title = styled.h2`
  font-size: ${(props) => props.theme.typography.fontSize[24]};
  margin-bottom: ${(props) => props.theme.grid(8)};
`

export const Action = styled.div`
  margin-top: ${(props) => props.theme.grid(4)};
`