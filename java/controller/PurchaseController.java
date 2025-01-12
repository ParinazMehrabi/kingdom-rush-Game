package controller;


import controller.spells.CoinController;
import controller.spells.FreezeController;
import controller.spells.HealthController;
import controller.spells.LittleBoyController;

import java.sql.SQLException;

import static controller.SignupController.player;

public class PurchaseController {
    private static PurchaseController purchaseController;

    private PurchaseController() {
    }

    public static PurchaseController getPurchaseController() {
        if(purchaseController == null)
            purchaseController = new PurchaseController();
        return purchaseController;
    }

    public void purchase(String spell) throws SQLException, ClassNotFoundException {
        String sqlCmd = null;
        String sqlCmd2 = null;
        System.out.println(spell);
        switch (spell)
        {
            case "FREEZE":
                sqlCmd = String.format("UPDATE backpack set FREEZE = FREEZE + 1 WHERE playerId= %s", 1);
                sqlCmd2 = String.format("UPDATE players set diamonds = diamonds - %s WHERE id= %s", FreezeController.getCoinController().getPrice(),player.getId());
                player.setDiamond(player.getDiamond() - FreezeController.getCoinController().getPrice());
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd2);
                break;
            case "LITTLEBOY":
                sqlCmd = String.format("UPDATE backpack set LITTLEBOY = LITTLEBOY + 1 WHERE playerId= %s", 1);
                sqlCmd2 = String.format("UPDATE players set diamonds = diamonds - %s WHERE id= %s", LittleBoyController.getLittleBoyController().getPrice(),player.getId());
                player.setDiamond(player.getDiamond() - LittleBoyController.getLittleBoyController().getPrice());
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd2);
                break;
            case "COIN":
                sqlCmd = String.format("UPDATE backpack set COIN = COIN + 1 WHERE playerId= %s", 1);
                sqlCmd2 = String.format("UPDATE players set diamonds = diamonds - %s WHERE id= %s", CoinController.getCoinController().getPrice(),player.getId());
                player.setDiamond(player.getDiamond() - CoinController.getCoinController().getPrice());
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd2);
                break;
            case "HEALTH":
                sqlCmd = String.format("UPDATE backpack set HEALTH = HEALTH + 1 WHERE playerId= %s", 1);
                sqlCmd2 = String.format("UPDATE players set diamonds = diamonds - %s WHERE id= %s", HealthController.getHealthController().getPrice(), player.getId());
                player.setDiamond(player.getDiamond() - HealthController.getHealthController().getPrice());
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd);
                DatabaseManager.getDatabaseManager().executeSQL(sqlCmd2);
                break;
        }
    }
}
