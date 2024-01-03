package CodeReview.ManipulacaodeString;

public class StringManipulation {
    
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        
        String fullName = firstName + " " + lastName;
        
        if (fullName.length() > 0) {
            System.out.println("Full Name: " + fullName);
        } else {
            System.out.println("Full Name is empty.");
        }
    }
}

