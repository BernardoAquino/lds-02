import styled from 'styled-components';

export const Card = styled.div`
  align-items: center;
  background-color: ${(props) => props.theme.color.neutral[50]};
  border-radius: ${(props) => props.theme.grid(0.5)};
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: ${(props) => props.theme.grid(2)};
`;

export const Info = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
`;

export const Name = styled.p`
  color: ${(props) => props.theme.color.neutral[100]};
  font-size: ${(props) => props.theme.typography.fontSize[14]};
  font-weight: ${(props) => props.theme.typography.fontWeight.bold};
`;

export const Owner = styled.p`
  color: ${(props) => props.theme.color.neutral[100]};
  font-size: ${(props) => props.theme.typography.fontSize[12]};
  font-weight: ${(props) => props.theme.typography.fontWeight.light};
`;

export const Actions = styled.div`
  display: flex;
  flex-direction: column;
`