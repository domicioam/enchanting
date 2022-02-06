import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class EnchantRandomizerShould {

    @Test
    @DisplayName("Pick correct enchantment accordingly to number")
    void pickCorrectEnchantmentAccordinglyToNumber() {
        int firstEnchantIndex = 0;
        MockEnchantRandomizer enchantRandomizer = new MockEnchantRandomizer(firstEnchantIndex);
        EnchantmentType[] values = EnchantmentType.values();
        EnchantmentType pickedEnchantment = enchantRandomizer.pickEnchantment().get();
        assertThat(pickedEnchantment, equalTo(values[firstEnchantIndex]));
    }

    @Test
    @DisplayName("Return empty when number outside of bounds")
    void returnEmptyWhenNumberOutsideOfBounds() {
        int indexOutsideOfBounds = 999;
        MockEnchantRandomizer enchantRandomizer = new MockEnchantRandomizer(indexOutsideOfBounds);
        EnchantmentType[] values = EnchantmentType.values();
        Optional<EnchantmentType> pickedEnchantment = enchantRandomizer.pickEnchantment();
        assertTrue(pickedEnchantment.isEmpty());
    }
}