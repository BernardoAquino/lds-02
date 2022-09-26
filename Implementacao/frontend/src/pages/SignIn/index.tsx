import React from 'react';

/** Components */
import SignIn from '../../components/organisms/SignIn';

/** Style */
import * as El from './SignIn.style';

const SignInPage = () => {
  return (
    <El.PageWrapper>
      <El.CardWrapper>
        <SignIn />
      </El.CardWrapper>
    </El.PageWrapper>
  )
};

export default SignInPage;