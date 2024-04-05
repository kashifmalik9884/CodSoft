import java.util.Random;
import java.util.Scanner;



public class Task1_Number_Game {
    public static int randomNum() {
        Random random = new Random();
        int r_num = random.nextInt(100);
        return r_num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int play = 0;
        int won = 0;
        while (true) {
            System.out.println("<------Enter Your Choice------>");
            System.out.println("You Have Only 10 Tries!!");
            System.out.print("1. Start New Game\n2. Retry Game\n3. Exit\n = ");
            int option = sc.nextInt();
            int randomNumber = randomNum();
            if (option >= 1 && option <= 2) {
                for (int i = 0; i < 10; i++) {
                    
                
                    System.out.print("Enter A Number From (1-100) To Play = ");
                    int num = sc.nextInt();
                    if (option == 1 || option == 2) {
                        
                        if (randomNumber == num) {
                            System.out.println("Your Guess The Right Number...");
                            play++;
                            won++;
                            break;
                        } else if (num < randomNumber) {
                            System.out.println("Too Low...");
                            play++;
                        } else if (num > randomNumber) {
                            System.out.println("Too High...");
                            play++;
                        } else {
                            System.out.println("Invalid Input!!");
                        }
                    }
                }
                System.out.println("Play = " + play);
                System.out.println("Won = " + won);

            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid Input Please Try Again!!");
            }
        }

    }
}