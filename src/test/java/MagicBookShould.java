import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MagicBookShould {

    private final Weapon weapon = new RegularWeapon("Dagger of the Nooblet");
    @Mock
    EnchantRandomizer enchantRandomizer;
    @InjectMocks
    MagicBook magicBook;

    @Test
    @DisplayName("Return enchanted weapon.")
    void returnEnchantedWeapon() {
        when(enchantRandomizer.pickEnchantment()).thenReturn(Optional.of(EnchantmentType.Fire));
        Weapon enchantedWeapon = magicBook.enchant(weapon);
        assertThat(enchantedWeapon.getName(), equalTo("Inferno Dagger of the Nooblet"));
    }

    @Test
    @DisplayName("Remove enchantment when enchant fails")
    void removeEnchantmentWhenEnchantFails() {
        when(enchantRandomizer.pickEnchantment()).thenReturn(Optional.empty());
        FireEnchantmentDecorator fireWeapon = new FireEnchantmentDecorator(weapon);
        Weapon resultWeapon = magicBook.enchant(fireWeapon);
        assertThat(resultWeapon, equalTo(weapon));
    }

    @Test
    @DisplayName("Repeat enchant when effect is repeated")
    void repeatEnchantWhenEffectIsRepeated() {
        when(enchantRandomizer.pickEnchantment())
            .thenReturn(Optional.of(EnchantmentType.Fire),
                    Optional.of(EnchantmentType.Fire),
                    Optional.of(EnchantmentType.Agility));

        Weapon enchantedWeapon = magicBook.enchant(new FireEnchantmentDecorator(weapon));
        assertThat(enchantedWeapon.getName(), equalTo(new AgilityEnchantmentDecorator(weapon).getName()));
    }
}
