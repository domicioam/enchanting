public class FireEnchantmentDecorator extends WeaponBaseDecorator {
    public FireEnchantmentDecorator(Weapon wrapee) {
        super(wrapee);
    }

    @Override
    public String getName() {
        return "Inferno " + super.getName();
    }
}
