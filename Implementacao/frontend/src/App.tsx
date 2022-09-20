import React from 'react';
import { 
  RouterProvider
} from 'react-router-dom';
import { ThemeProvider } from 'styled-components';

/** Routes */
import routes from './routes';

/** Theme */
import { themeConfig } from './utils/theme';

function App() {
  return (
    <ThemeProvider theme={themeConfig}>
      <RouterProvider router={routes} />
    </ThemeProvider>
  );
}

export default App;
