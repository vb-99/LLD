package practice.lld;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Snake extends BoardEntity {

    public Snake(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }
}
