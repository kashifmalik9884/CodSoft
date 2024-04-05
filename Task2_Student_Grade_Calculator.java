import java.util.Scanner;

public class Task2_Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float totalMarks = 0.0f;
        String grade = null;
        System.out.print("Enter The Number of Subject = ");
        int numberOfSubject = sc.nextInt();
        System.out.println("<------Enter Your Marks In Each Subjects Out Of 100------>");
        for (int i = 1; i <= numberOfSubject; i++) {
            System.out.print("Enter The Number In "+i+" Subject = ");
            float marks = sc.nextInt();
            totalMarks += marks;
        }
        float averagePercentage = totalMarks / numberOfSubject;
        if (averagePercentage<= 100 && averagePercentage >= 91) {
            grade = "A1";
        }
        else if (averagePercentage<= 90 && averagePercentage >= 81) {
            grade = "A2";
        }
        else if (averagePercentage<= 80 && averagePercentage >= 71) {
            grade = "B1";
        }
        else if (averagePercentage<= 70 && averagePercentage >= 61) {
            grade = "B2";
        }
        else if (averagePercentage<= 60 && averagePercentage >= 51) {
            grade = "C1";
        }
        else if (averagePercentage<= 50 && averagePercentage >= 41) {
            grade = "C2";
        }
        else if (averagePercentage<= 40 && averagePercentage >= 31) {
            grade = "D";
        }
        else if (averagePercentage<= 30 && averagePercentage >= 21) {
            grade = "E1";
        }
        else if (averagePercentage<= 20 && averagePercentage >= 0) {
            grade = "E2";
        }
        else{
            System.out.println("Invalid Numbers!!");
        }
        System.out.println("The Total Marks Is = "+totalMarks);
        System.out.println("The Average Percentage Is = "+averagePercentage);
        System.out.println("The Grade Is = "+grade);

    }
}
