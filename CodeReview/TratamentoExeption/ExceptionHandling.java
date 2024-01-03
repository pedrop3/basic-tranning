package CodeReview.TratamentoExeption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {
    
    public static void main(String[] args) {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("example.txt"));
            String line = reader.readLine();
            System.out.println("Read line: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
