package facade;

import scanner.token.Token;

public class TokenFacade {
    private static TokenFacade tokenFacade = null;
    private Token token;

    private TokenFacade() {
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public static TokenFacade getTokenFacade() {
        return (tokenFacade == null) ? tokenFacade = new TokenFacade() : tokenFacade;
    }
}
