import java.util.Optional;
import java.util.Random;

public class EnchantRandomizer {
    public Optional<EnchantmentType> pickEnchantment() {
        EnchantmentType[] values = EnchantmentType.values();

        int pick = nextInt(values.length);

        if(pick < values.length) // from 0 to (length - 1)
            return Optional.of(values[pick]);
        else // values[length] => index out of bounds
            return Optional.empty();
    }

    protected int nextInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
