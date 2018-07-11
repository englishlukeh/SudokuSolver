import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        System.out.println("Please input sudoku puzzle: ");

        Scanner sc = new Scanner(System.in);
        String puzzleString = sc.nextLine();

        int i = (int)Math.sqrt(puzzleString.length());

        Square puzzle = new Square(i);
        puzzle.initialize(puzzleString);
        puzzle.printOut();
        puzzle.solve();
        puzzle.printOut();

    }
}
