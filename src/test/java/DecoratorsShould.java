import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DecoratorsShould {
    @Test
    @DisplayName("Apply only second enchantment")
    void applyOnlySecondEnchantment() {
        Weapon weapon = new RegularWeapon("Dagger of the Nooblet");
        FireEnchantmentDecorator fireEnchantmentDecorator = new FireEnchantmentDecorator(weapon);
        AgilityEnchantmentDecorator agilityEnchantmentDecorator = new AgilityEnchantmentDecorator(fireEnchantmentDecorator);
        assertThat(agilityEnchantmentDecorator.getName(), equalTo("Quick Dagger of the Nooblet"));
    }
}
