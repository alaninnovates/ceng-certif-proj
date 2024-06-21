import java.util.Scanner;
class RPS {
    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        Scanner s = new Scanner(System.in);
        boolean gameActive = true;
        while (gameActive) {
            int currTry = 0;
            int plrWins = 0;
            while (currTry < 3) {
                System.out.println("=> Choose Rock, Paper or Scissors <=");
                String choice = s.nextLine();
                String computerChoice = options[(int) (Math.random() * options.length)];
                System.out.println("Computer chose: " + computerChoice);
                if (choice.equals(computerChoice)) {
                    System.out.println("Draw");
                } else if (choice.equals("Rock") && computerChoice.equals("Scissors") || choice.equals("Paper") && computerChoice.equals("Rock") || choice.equals("Scissors") && computerChoice.equals("Paper")) {
                    plrWins++;
                    currTry++;
                    System.out.println("You won");
                } else {
                    System.out.println("You lost");
                    currTry++;
                }
            }
            System.out.println("=> Game over <=");
            if (plrWins >= 2) {
                System.out.println("$$ You won the game");
            } else {
                System.out.println("%% You lost the game");
            }
            System.out.println("Do you want to play again? (yes/no)");
            String response = s.nextLine();
            if (response.equals("yes")) {
                continue;
            } else {
                gameActive = false;
            }
        }
    }
}