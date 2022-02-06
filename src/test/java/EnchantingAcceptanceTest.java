import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class EnchantingAcceptanceTest {

    @Test
    @DisplayName("Should have only one enchantment active")
    void shouldHaveOnlyOneEnchantmentActive() {
        Weapon weapon = new RegularWeapon("Dagger of the Nooblet");
        MagicBook magicBook = new MagicBook(new EnchantRandomizer());
        Durance durance = new Durance(weapon, magicBook);
        durance.enchant();
        String weaponDescription = durance.describeWeapon();
        String[] weaponDescriptionWords = weaponDescription.split(" ");
        assertThat(weaponDescriptionWords[0], not("Dagger"));
        assertThat(weaponDescriptionWords[1], equalTo("Dagger"));
    }
}
