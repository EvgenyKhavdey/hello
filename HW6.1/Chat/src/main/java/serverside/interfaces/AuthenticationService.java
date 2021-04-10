package serverside.interfaces;

public interface AuthenticationService {

    void start();
    void stop();
    String getNickByLoginAndPassword(String login, String password);
}