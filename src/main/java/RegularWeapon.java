import java.util.Optional;

public class RegularWeapon implements Weapon {

    private String name;

    public RegularWeapon(String name) {
        this.name = name;
    }

    @Override
    public String stats() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<Weapon> baseWeapon() {
        return Optional.empty();
    }
}
