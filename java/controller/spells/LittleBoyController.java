package controller.spells;

import model.interfaces.Spell;

public class LittleBoyController implements Spell {
    private static LittleBoyController littleBoyController;

    private LittleBoyController() {
    }

    public static LittleBoyController getLittleBoyController () {
        if(littleBoyController == null)
            littleBoyController = new LittleBoyController();
        return littleBoyController;
    }
    @Override
    public int getPrice() {
        return 999;
    }

    @Override
    public void drop()
    {

    }
}
