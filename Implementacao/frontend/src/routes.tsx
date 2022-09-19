import React from 'react';

import { createBrowserRouter } from 'react-router-dom';

import { HOME_URL, PROFILE_URL_BASE, SIGNUP_URL } from './constants';

import Home from './pages/Home'
import Profile from './pages/Profile'
import SignUp from './pages/SignUp'

const routes = [
  {
    path: HOME_URL,
    element: <Home />
  },
  {
    path: PROFILE_URL_BASE,
    element: <Profile />
  },
  {
    path: SIGNUP_URL,
    element: <SignUp />
  }
]

export default createBrowserRouter(routes);