package practice.lld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements Split {

    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails) {
        Map<User,Double> percentageSplits = (Map<User, Double>) splitDetails.get("percentages");
        Map<User,Double> splits = new HashMap<>();
        for(User participant:participants){
            double amountPerPerson = percentageSplits.getOrDefault(participant,0.0) * amount/100;
            splits.put(participant,amountPerPerson);
        }
        return splits;
    }
}
