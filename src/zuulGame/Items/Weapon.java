package zuulGame.Items;

public interface Weapon extends Item {
    public int getMinDamage();

    public int getMaxDamage();

    public int attack();

    public String getName();
}
