import { createGlobalStyle } from 'styled-components';
 
const GlobalStyle = createGlobalStyle`
  body {
    border: none;
    margin: 0;
    outline: 0;
    padding: 0;
  }

  body,
  button { 
    font-family: 'Open Sans', Helvetica, Sans-Serif;
  }
`;
 
export default GlobalStyle;