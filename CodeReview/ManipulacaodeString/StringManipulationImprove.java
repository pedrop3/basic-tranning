package CodeReview.ManipulacaodeString;

public class StringManipulationImprove {
    
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";

        StringBuilder fullNameBuilder = new StringBuilder();
        
        if(firstName != null && lastName != null) {
            fullNameBuilder.append(firstName).append(" ").append(lastName);
        }
        
        String fullName = fullNameBuilder.toString();
        System.out.println("Full Name: " + (fullName.length() > 0 ? fullName : "Full Name is empty."));

    }
}

