package controller.spells;

import model.interfaces.Spell;

public class CoinController implements Spell {
    private static CoinController coinController;

    private CoinController() {
    }

    public static CoinController getCoinController() {
        if(coinController == null)
            coinController = new CoinController();
        return coinController;
    }
    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public void drop() {

    }
}
