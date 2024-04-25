import java.util.Scanner;

public class Interactive {
    private Scanner scanner;

    // Constructor to initialize the scanner
    public Interactive(){
        scanner = new Scanner(System.in);
    }

    //Method to get user input
    public String getUserInput(String prompt ){
        System.out.println(prompt + ":");
        return scanner.nextLine();
    }

    //Method to display message to user
    public void displayMessage(String message){
        System.out.println(message);
    }

    //Method to close scanner
    public void close(){
        scanner.close();
    }

    





}
