package practice.lld;

public class SplitFactory {
    public static Split createSplit(String SplitType){
        switch(SplitType){
            case "EQUAL":
                return new EqualSplit();
            case "PERCENTAGE":
                return new PercentageSplit();
            default:
                throw new IllegalArgumentException("Invalid SplitType");
        }
    }
}
