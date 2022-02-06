import java.util.Optional;

public class WeaponBaseDecorator implements Weapon {
    protected Weapon decorated;
    protected Weapon baseItem;

    public WeaponBaseDecorator(Weapon decorated) {
        this.decorated = decorated;
        this.baseItem = decorated.baseWeapon().orElse(this.decorated);
    }

    @Override
    public String stats() {
        return null;
    }

    @Override
    public String getName() {
        return baseItem.getName();
    }

    @Override
    public Optional<Weapon> baseWeapon() {
        return Optional.of(baseItem);
    }
}
