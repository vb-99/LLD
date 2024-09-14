package practice.lld;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ladder extends BoardEntity {

    public Ladder(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }
}
