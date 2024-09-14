package practice.lld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class Dice {
    private Integer minValue;
    private Integer maxValue;
    private Integer numberOfDice;

    public int getDiceRollValue(){
        Integer currentValue = 0;
        for(int i = 0; i < numberOfDice; i++){
            currentValue += (int) (Math.random() * ((maxValue - minValue) + minValue));
        }
       return currentValue;
    }


}
