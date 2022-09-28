import React from 'react';

import { createBrowserRouter } from 'react-router-dom';

import { AGENT_SIGNUP_URL, CREATE_CAR_URL, EDIT_CAR_URL, HOME_URL, LIST_CARS_URL, PROFILE_URL_BASE, SIGNIN_URL, SIGNUP_URL } from './constants';

import Home from './pages/Home';
import CreateVehicle from './pages/CreateVehicle';
import EditVehicle from './pages/EditVehicle';
import ListVehicles from './pages/ListVehicles';
import Profile from './pages/Profile';
import SignIn from './pages/SignIn';
import AgentSignUp from './pages/SignUp/AgentSignUp';
import UserSignUp from './pages/SignUp/UserSignUp';

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
    path: SIGNIN_URL,
    element: <SignIn />
  },
  {
    path: SIGNUP_URL,
    element: <UserSignUp />
  },
  {
    path: AGENT_SIGNUP_URL,
    element: <AgentSignUp />
  },
  {
    path: LIST_CARS_URL,
    element: <ListVehicles />
  },
  {
    path: CREATE_CAR_URL,
    element: <CreateVehicle />
  },
  {
    path: EDIT_CAR_URL,
    element: <EditVehicle />
  },
]

export default createBrowserRouter(routes);