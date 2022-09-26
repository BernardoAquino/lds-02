import React from 'react';

/** Components */
import UserSignUp from '../../components/Organisms/SignUpContainer/UserSignUp';

/** Style */
import * as El from './SignUp.style';

const UserSignUpPage = () => {
  return (
    <El.PageWrapper>
      <El.CardWrapper>
        <UserSignUp />
      </El.CardWrapper>
    </El.PageWrapper>
  )
};

export default UserSignUpPage;