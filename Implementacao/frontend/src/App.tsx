import React from 'react';
import { 
  RouterProvider
} from 'react-router-dom';
import { ThemeProvider } from 'styled-components';

/** Routes */
import routes from './routes';

/** Theme */
import { themeConfig } from './utils/theme';

/** Style */
import GlobalStyle from './utils/getGlobalStyle';

function App() {
  return (
    <ThemeProvider theme={themeConfig}>
      <GlobalStyle />
      <RouterProvider router={routes} />
    </ThemeProvider>
  );
}

export default App;
