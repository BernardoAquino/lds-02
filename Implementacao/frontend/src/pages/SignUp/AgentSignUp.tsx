import React from 'react';

/** Components */
import AgentSignUp from '../../components/Organisms/SignUpContainer/AgentSignUp';

/** Style */
import * as El from './SignUp.style';

const AgentSignUpPage = () => {
  return (
    <El.PageWrapper>
      <El.CardWrapper>
        <AgentSignUp />
      </El.CardWrapper>
    </El.PageWrapper>
  )
};

export default AgentSignUpPage;