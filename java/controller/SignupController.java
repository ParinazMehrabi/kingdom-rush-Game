package controller;


import exceptions.RepeatedID;
import model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SignupController
{
    public static Player player;
    private static SignupController signupController;

    private SignupController() {
    }
    public static SignupController getSignupController()
    {
        if (signupController == null)
            signupController = new SignupController();
        return signupController;
    }


    public static void setSignupController(SignupController signupController) {
        SignupController.signupController = signupController;
    }
    public boolean signup(String username,String password) throws SQLException, ClassNotFoundException, RepeatedID {
        String sqlCmd = String.format("SELECT password FROM players WHERE username = '%s'",username);
        ResultSet resultSet = DatabaseManager.getDatabaseManager().executeQuery(sqlCmd);
        if(resultSet != null && resultSet.next())
        {
            throw new RepeatedID("This id exist");
        }
        String innerCmd = String.format("INSERT INTO players (username,password) VALUES ('%s','%s')",username,password);
        sqlCmd = String.format("SELECT * FROM players WHERE username = '%s'",username);
        resultSet = DatabaseManager.getDatabaseManager().executeQuery(sqlCmd);
        while (resultSet.next())
        {
            player = new Player(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getInt("level"),resultSet.getInt("diamonds"),resultSet.getInt("health"));
            System.out.println(player.getId());
            System.out.println(player.getUsername());
        }
        String innerCmd2 = String.format("INSERT INTO backpack VALUES ()");
        DatabaseManager.getDatabaseManager().executeSQL(innerCmd);
        DatabaseManager.getDatabaseManager().executeSQL(innerCmd2);
        return true;
    }
}
