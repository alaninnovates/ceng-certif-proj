import java.util.Scanner;
class Hangman {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Hangman h = new Hangman();
        boolean gameActive = true;
        while (gameActive) {
            h.gameLoop();
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = s.nextLine();
            if (playAgain.equals("no")) {
                gameActive = false;
            }
        }
    }
    public void gameLoop() {
        String word = this.randomWord();
        String wordWithUnderscores = this.substituteUndercores(word);
        int currTry = 0;
        while (currTry < 6) {
            System.out.println(wordWithUnderscores);
            System.out.println("Enter a guess (letter or word): ");
            String guessStr = s.nextLine();
            if (guessStr.equals(word)) {
                System.out.println("You win!");
                break;
            }
            char guess = guessStr.charAt(0);
            if (word.indexOf(guess) == -1) {
                currTry++;
                System.out.println("Incorrect guess. You have " + (6 - currTry) + " tries left.");
                continue;
            }
            wordWithUnderscores = this.evaluateGuess(word, wordWithUnderscores, guess);
            if (wordWithUnderscores.equals(word)) {
                System.out.println("You win!");
                break;
            }
        }
        if (currTry == 5) {
            System.out.println("You lost");
        }
    }
    public String randomWord() {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "pear", "quince", "raspberry", "strawberry", "tangerine", "watermelon"};
        return words[(int) (Math.random() * words.length)];
    }
    public String substituteUndercores(String word) {
        return word.replaceAll(".", "_");
    }
    public String evaluateGuess(String word, String underscores, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                underscores = underscores.substring(0, i) + guess + underscores.substring(i + 1);
            }
        }
        return underscores;
    }
}