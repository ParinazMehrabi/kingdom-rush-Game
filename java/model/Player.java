package model;

public class Player
{
    private int id;
    private String username;
    private String password;
    private int level;
    private int diamond;
//    private ArrayList<Spell> backPack;
    private int health;

    public Player(int id, String username, String password, int level, int diamond, int health)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.diamond = diamond;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

//    public ArrayList<Spell> getBackPack() {
//        return backPack;
//    }
//
//    public void setBackPack(ArrayList<Spell> backPack) {
//        this.backPack = backPack;
//    }
}
