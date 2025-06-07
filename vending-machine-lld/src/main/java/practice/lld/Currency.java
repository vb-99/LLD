package practice.lld;

public enum Currency {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    private final int val;

    Currency(int value){
        this.val=value;
    }
    public int getValue(){
        return val;
    }
}
