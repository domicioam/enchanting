public class MockEnchantRandomizer extends EnchantRandomizer {
    private int nextInt;

    public MockEnchantRandomizer(int nextInt) {
        this.nextInt = nextInt;
    }

    @Override
    protected int nextInt(int bound) {
        return nextInt;
    }
}
