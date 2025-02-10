package practice.lld;

public enum Money {
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Money(int val) {
        this.value = val;
    }
    public int getValue() {
        return value;
    }
}
