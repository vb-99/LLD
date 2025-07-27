package practice.lld;

public enum Cash {
    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5),
    ONE(1);


   private final int value;

     Cash(int value) {
        this.value = value;
    }
    public int getValue() {
         return value;
    }

}
