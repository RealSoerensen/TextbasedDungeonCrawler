package zuulGame.Items;

public interface Weapon {
    public int getMinDamage();

    public int getMaxDamage();

    public int attack();

    public String getName();
}