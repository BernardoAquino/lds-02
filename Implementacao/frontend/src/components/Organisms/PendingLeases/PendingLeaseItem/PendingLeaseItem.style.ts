import styled from 'styled-components';

type StatusStylingProps = {
  isLeased: boolean;
};

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

export const Vehicle = styled.p`
  color: ${(props) => props.theme.color.neutral[100]};
  font-size: ${(props) => props.theme.typography.fontSize[14]};
  font-weight: ${(props) => props.theme.typography.fontWeight.bold};
  margin-bottom: ${(props) => props.theme.grid(1)};
`;

export const Owner = styled.p`
  color: ${(props) => props.theme.color.neutral[100]};
  font-size: ${(props) => props.theme.typography.fontSize[12]};
  font-weight: ${(props) => props.theme.typography.fontWeight.light};
`;

export const Client = Owner;

export const Actions = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: ${(props) => props.theme.grid(3)};

  & > :not(:first-child) {
    margin-top: ${(props) => props.theme.grid(1)};
  }
`