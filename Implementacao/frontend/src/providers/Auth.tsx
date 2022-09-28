import { createContext, ReactNode, useContext, useState } from "react"
import { useNavigate } from "react-router-dom";
import { SIGNIN_URL } from "../constants";

type AuthProviderProps = {
    children: ReactNode;
};

type SessionContext = {
    session: Session;
    updateSession: (session: Session) => void;
}

type Session = {
    name: string;
    token: string;
};

const DEFAULT_SESSION = {
    name: '',
    token: '',
    isAuthenticated: false,
};

const getDefaultSession = () => {
    const localStorageSession = localStorage.getItem('session');

    if (localStorageSession) {
        return JSON.parse(localStorageSession);
    }

    return DEFAULT_SESSION;
}

const AuthContext = createContext<SessionContext>({
    session: getDefaultSession(),
    updateSession: function(updatedSession: Session) {
        this.session = { ...this.session, ...updatedSession };
        localStorage.setItem('session', JSON.stringify(this.session));
    }
});

export const useSession = () => useContext(AuthContext);

export const AuthProvider = ({
    children
}: AuthProviderProps) => {
    const [session, setSession] = useState<Session>(getDefaultSession());

    const updateSession = (session: Session) => setSession((prevSession: Session) => {
        const newSession = { ...prevSession, ...session };

        localStorage.setItem('session', JSON.stringify(newSession));

        return newSession;
    })

    return (
        <AuthContext.Provider value={{ session, updateSession }}>
            {children}
        </AuthContext.Provider>
    );
};

export const AuthWall = ({ children }: AuthProviderProps) => {
    const navigate = useNavigate();
    const { session } = useSession();

    if (!session.token) {
        navigate(SIGNIN_URL);

        return null;
    }

    return children;
}