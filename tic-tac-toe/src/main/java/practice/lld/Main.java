package practice.lld;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactoryImpl();
        TicTacToeGame ticTacToeGame = new TicTacToeGame("X_Player","O_Player",new HumanPlayerStrategy(),new HumanPlayerStrategy(),playerFactory,3,3);
        ticTacToeGame.play();
    }
}