package practice.lld;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@AllArgsConstructor
public class Board {
    private int size;
    private Map<Integer,BoardEntity> jumpers;
    private Queue<Player> turnQueue;
    public  Map<Integer,Integer> playerPositionMap;

    public Board(int size) {
        this.size = size;
        this.jumpers = new HashMap<>();
        this.turnQueue = new LinkedList<>();
        this.playerPositionMap = new HashMap<>();
    }

    private void initialiseBoard(){
        Dice player1Dice = new Dice(1,6,1);
        Dice player2Dice = new Dice(1,6,1);
        Player p1 = new Player(1,"Player1",player1Dice);
        Player p2 = new Player(2,"Player2",player2Dice);
        Snake snake1 = new Snake(20,10);
        Snake snake2 = new Snake(30,5);
        Snake snake3 = new Snake (80,47);
        Ladder ladder1 = new Ladder(15,60);
        Ladder ladder2 = new Ladder(86,99);
        Ladder ladder3 = new Ladder (28,39);
        jumpers.put(20,snake1);
        jumpers.put(30,snake2);
        jumpers.put(80,snake3);
        jumpers.put(15,ladder1);
        jumpers.put(86,ladder2);
        jumpers.put(28,ladder3);
        playerPositionMap = new HashMap<>();
        playerPositionMap.put(p1.getId(),0);
        playerPositionMap.put(p2.getId(),0);
        turnQueue.add(p1);
        turnQueue.add(p2);

        this.size = 100;
    }

    public void startGame() {
        initialiseBoard();
        while (turnQueue.size() != playerPositionMap.size() - 1) {
            Player playerToRollDice = turnQueue.poll();
            Integer playerCurrentPosition = playerPositionMap.get(playerToRollDice.getId());
            Integer offset = playerToRollDice.getDice().getDiceRollValue();
            BoardEntity jumper = jumpers.get(playerCurrentPosition + offset);
            Integer jumperOffset = 0;
            if(jumper != null){
                jumperOffset = jumper.endPosition - jumper.startPosition;
            }
            if (playerCurrentPosition + offset + jumperOffset >= size) {
                turnQueue.add(playerToRollDice);
            } else if (playerCurrentPosition + offset + jumperOffset == size - 1) {
                System.out.println(playerToRollDice.getName() + " won!");
            } else {
                playerPositionMap.put(playerToRollDice.getId(), playerCurrentPosition + offset + jumperOffset);
                System.out.println(playerToRollDice.getName() + " has reached: " + playerPositionMap.get(playerToRollDice.getId()));
                turnQueue.add(playerToRollDice);
            }

        }
    }


}
