public class MagicBook {
    private EnchantRandomizer enchantRandomizer;

    public MagicBook(EnchantRandomizer enchantRandomizer) {
        this.enchantRandomizer = enchantRandomizer;
    }

    public Weapon enchant(Weapon weapon) {
        Weapon enchantedWeapon = enchantRandomizer.pickEnchantment().map(e -> switch (e) {
            case Fire -> (Weapon) new FireEnchantmentDecorator(weapon);
            case Agility -> (Weapon) new AgilityEnchantmentDecorator(weapon);
        }).orElse(weapon.baseWeapon().orElse(weapon));

        if(enchantedWeapon.getName().equals(weapon.getName()))
            return enchant(weapon);
        else
            return enchantedWeapon;
    }
}
