package controller;

import java.sql.*;

public class DatabaseManager
{
    private static DatabaseManager databaseManager;
    public static DatabaseManager getDatabaseManager()
    {
        if (databaseManager == null)
            databaseManager = new DatabaseManager();
        return databaseManager;
    }

    String URL= "jdbc:mysql://localhost/KingdomRush";
    String user = "root";
    String pass = "";

    public Boolean executeSQL (String SqlCmd) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,user,pass);
        Statement s = con.prepareStatement(SqlCmd);
        s.execute(SqlCmd);
        con.close();
        return true;
    }
    public ResultSet executeQuery (String SqlCmd)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, user, pass);
            Statement s = con.prepareStatement(SqlCmd);
            ResultSet rs = s.executeQuery(SqlCmd);
            return rs;
        }
        catch (Exception ex)
        {
            return null;
        }

    }

}
