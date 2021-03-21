package serverside.service;

import com.sun.javafx.UnmodifiableArrayList;
import lombok.SneakyThrows;
import serverside.interfaces.AuthenticationService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<User> usersList;

    public AuthenticationServiceImpl() throws SQLException, ClassNotFoundException {
        usersList = new ArrayList<>();
        init();

        try (Connection connection = getConnection()) {
            statements(connection);
            prepare(connection);
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select * from user");
                while (resultSet.next()) {
                    usersList.add(new User(resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("nick")));
                }

            }

        }
    }

    private static void init() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
    private static void statements(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table user(login varchar(100), password varchar(100), nick varchar(100))");
        }
    }


    private static void prepare(Connection connection) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into user(login, password, nick) values (?, ?, ?)")){
            preparedStatement.setString(1, "A");
            preparedStatement.setString(2, "A");
            preparedStatement.setString(3, "A");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "B");
            preparedStatement.setString(2, "B");
            preparedStatement.setString(3, "B");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "C");
            preparedStatement.setString(2, "C");
            preparedStatement.setString(3, "C");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
        }
    }



    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        /*for (User u : usersList) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u.nick;
            }
        }*/
        //return "";

        return usersList.stream()
                .map(a -> {
                    if (a.login.equals(login) && a.password.equals(password)) {
                        return a.nick;
                    }
                    return "";
                }).collect(Collectors.joining());
    }

    public class User {

        private String login;
        private String password;
        private String nick;

        public User(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getNick() {
            return nick;
        }
    }
}