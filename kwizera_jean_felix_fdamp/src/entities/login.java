package entities;
import java.util.Scanner;
public class login {
	public class LoginSystem {
	    public static void main(String[] args) {
	        // Assuming a simple username and password
	        String correctUsername = "user";
	        String correctPassword = "password";

	        // Get user input
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter username: ");
	        String enteredUsername = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String enteredPassword = scanner.nextLine();

	        // Check if the entered credentials are correct
	        if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
	            System.out.println("Login successful!");
	        } else {
	            System.out.println("Invalid username or password. Login failed.");
	        }

	        // Close the scanner
	        scanner.close();
	    }
	}

	

	}


