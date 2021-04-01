package pl.coderslab.services;

public interface SecurityService {
    String findLoggedInName();

    void autoLogin(String username, String password);
}
