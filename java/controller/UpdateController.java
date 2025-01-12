package controller;


import exceptions.RepeatedID;
import model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

import static controller.SignupController.player;


public class UpdateController
{
    private Player account;
    private static UpdateController updateController;

    private UpdateController() {
    }
    public static UpdateController getUpdateController()
    {
        if (updateController == null)
            updateController = new UpdateController();
        return updateController;
    }

    public Player getAccount() {
        return account;
    }

    public void setAccount(Player account) {
        this.account = account;
    }

    public static void setUpdateController(UpdateController updateController) {
        UpdateController.updateController = updateController;
    }
    public boolean updatePassword(String password) throws SQLException, ClassNotFoundException
    {
        String sqlCmd = String.format("UPDATE players SET password ='%s' WHERE username = '%s'",password,player.getUsername());
        return DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
    }
    public boolean updateUsername(String username) throws RepeatedID, SQLException, ClassNotFoundException {
        String sqlCmd = String.format("SELECT password FROM players WHERE username = '%s'",username);
        ResultSet resultSet = DatabaseManager.getDatabaseManager().executeQuery(sqlCmd);
        if(resultSet != null && resultSet.next())
        {
            throw new RepeatedID("This id exist");
        }
        sqlCmd = String.format("UPDATE players set username='%s' WHERE username= '%s'",username,player.getUsername());
        return DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
    }
}
