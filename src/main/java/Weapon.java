import java.util.Optional;

public interface Weapon {
    String stats() ;
    String getName();
    Optional<Weapon> baseWeapon();
}
