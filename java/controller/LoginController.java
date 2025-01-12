package controller;


import exceptions.IdNotFound;
import exceptions.WrongPassword;
import model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

import static controller.SignupController.player;

public class LoginController {
    private static LoginController loginController;

    private LoginController() {
    }

    public static LoginController getLoginController() {
        if(loginController == null)
            loginController = new LoginController();
        return loginController;
    }

    public boolean login(String username, String password) throws SQLException, WrongPassword, IdNotFound {
        String sqlCmd = String.format("SELECT password FROM players WHERE username = '%s'",username);
        ResultSet resultSet = DatabaseManager.getDatabaseManager().executeQuery(sqlCmd);
        if(resultSet == null ||  !resultSet.next())
            throw new IdNotFound("This id is not available");
        if(resultSet.next() && !resultSet.getString("password").equals(password))
            throw new WrongPassword("Your password is not correct");
        sqlCmd = String.format("SELECT * FROM players WHERE username = '%s'",username);
        resultSet = DatabaseManager.getDatabaseManager().executeQuery(sqlCmd);
        while (resultSet.next())
        {
            player = new Player(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getInt("level"),resultSet.getInt("diamonds"),resultSet.getInt("health"));
            System.out.println(player.getId());
            System.out.println(player.getUsername());
        }
        return true;
    }
}
