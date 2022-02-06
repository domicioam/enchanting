import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

public class DuranceShould {
    @Test
    @DisplayName("Describe weapon with enchanting in its name.")
    void describeWeaponWithEnchantingInItsName() {
        MagicBook magicBook = Mockito.mock(MagicBook.class);
        Weapon weapon = new RegularWeapon("Dagger of the Nooblet");
        String enchantedWeaponDescription = "Inferno Dagger of the Nooblet";
        when(magicBook.enchant(weapon)).thenReturn(new RegularWeapon(enchantedWeaponDescription));
        Durance durance = new Durance(weapon, magicBook);
        durance.enchant();
        assertThat(durance.describeWeapon(), equalTo(enchantedWeaponDescription));
    }
}
