package model.tower;

public abstract class Tower
{
    private double destructionPower;
    private double constructionCost;
    private double range;
    private double x;
    private double y;

    public Tower(double destructionPower, double constructionCost, double range, double x, double y) {
        this.destructionPower = destructionPower;
        this.constructionCost = constructionCost;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public double getDestructionPower() {
        return destructionPower;
    }

    public void setDestructionPower(double destructionPower) {
        this.destructionPower = destructionPower;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public void setConstructionCost(double constructionCost) {
        this.constructionCost = constructionCost;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
