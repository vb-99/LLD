package practice.lld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public Move getMove(Board board) {
        while (true) {
            try {
                System.out.println("Please enter the row to select the piece");
                int row = scanner.nextInt();
                System.out.println("Please enter the column to select the piece");
                int col = scanner.nextInt();
               Cell startCell = board.getCell(row,col);
                System.out.println("Please enter the row to select the destination");
                row = scanner.nextInt();
                System.out.println("Please enter the column to select the destination");
                 col = scanner.nextInt();
                 Cell endCell = board.getCell(row,col);
                 return new Move(startCell,endCell);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.Please enter a valid position");
                scanner.nextLine();
            }

        }

    }
}
