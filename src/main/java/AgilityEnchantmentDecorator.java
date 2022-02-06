public class AgilityEnchantmentDecorator extends WeaponBaseDecorator{
    public AgilityEnchantmentDecorator(Weapon wrapee) {
        super(wrapee);
    }

    @Override
    public String getName() {
        return "Quick " + super.getName();
    }
}
