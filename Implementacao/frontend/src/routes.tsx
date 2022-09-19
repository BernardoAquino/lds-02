import { createBrowserRouter } from 'react-router-dom';

import { HOME_URL, PROFILE_URL_BASE } from './constants';

import Home from './pages/Home'
import Profile from './pages/Profile'

const routes = [
  {
    path: HOME_URL,
    element: <Home />
  },
  {
    path: PROFILE_URL_BASE,
    element: <Profile />
  }
]

export default createBrowserRouter(routes);