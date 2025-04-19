package practice.lld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    Scanner scanner;

    public HumanPlayerStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            try {
                System.out.println("Please enter the row to make the move");
                int row = scanner.nextInt();
                System.out.println("Please enter the column to make the move");
                int col = scanner.nextInt();
                Position position = new Position(row, col);
                if (board.validate(position)) {
                    return position;
                } else {
                    System.out.println("Please enter a valid position");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.Please enter a valid position");
                scanner.nextLine();
            }

            }
    }
}
