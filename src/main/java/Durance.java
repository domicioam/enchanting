public class Durance {
    Weapon weapon;
    MagicBook magicBook;

    public Durance(Weapon weapon, MagicBook magicBook) {
        this.weapon = weapon;
        this.magicBook = magicBook;
    }

    public void enchant() {
        weapon = magicBook.enchant(weapon);
    }

    public String describeWeapon() {
        return weapon.getName();
    }
}
