package controller.spells;

import model.interfaces.Spell;

public class FreezeController implements Spell
{
    private static FreezeController freezeController;

    private FreezeController() {
    }

    public static FreezeController getCoinController() {
        if(freezeController == null)
            freezeController = new FreezeController();
        return freezeController;
    }
    @Override
    public int getPrice() {
        return 250;
    }

    @Override
    public void drop() {

    }
}
