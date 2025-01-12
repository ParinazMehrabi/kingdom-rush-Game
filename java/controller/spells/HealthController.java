package controller.spells;

import model.interfaces.Spell;

public class HealthController implements Spell {
    private static HealthController healthController;

    private HealthController() {
    }

    public static HealthController getHealthController() {
        if(healthController == null)
            healthController = new HealthController();
        return healthController;
    }
    @Override
    public int getPrice() {
        return 350;
    }

    @Override
    public void drop() {

    }
}
