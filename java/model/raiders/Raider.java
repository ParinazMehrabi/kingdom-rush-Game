package model.raiders;

public abstract class Raider
{
    private int health;
    private double speed;
    private int loot;
    private int pathBreaks;


    public Raider(int health, double speed, int loot)
    {
        this.health = health;
        this.speed = speed;
        this.loot = loot;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }
}
