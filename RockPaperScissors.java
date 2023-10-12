import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] choices = {"rock", "paper", "scissors"};
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors or quit): ");
            String playerChoice = scanner.nextLine().toLowerCase();
            
            if (playerChoice.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            
            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
                continue;
            }
            
            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            
            System.out.println("Computer chose: " + computerChoice);
            
            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
    
    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        }
        
        if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
            (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win!";
        }
        
        return "Computer wins!";
    }
}
