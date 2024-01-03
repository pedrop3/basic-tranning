package CodeReview.TratamentoExeption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingImprove {

    public static void main(String[] args) {

        readFile();

    }

    private static void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {

            String line = reader.readLine();
            System.out.println("Read line: " + line);

        } catch (InvalideNameFileExpetion e) {
            // logger.error("Error: Invalid file name. Name example: input.txt", e);
            e.printStackTrace();

        } catch (IOException e) {
            // logger.error("Error reading file", e);
            e.printStackTrace();
        } catch (Exception e) {
            // logger.error("Error ", e);
            e.printStackTrace();
        }
    }

    public class BusinessException extends RuntimeException {

        private final String code;
        private final String message;

        public BusinessException(String message, String code) {
            super(String.format("[%s] - %s", code, message));

            this.code = code;
            this.message = message;
        }

    }

    public class InvalideNameFileExpetion extends BusinessException {

        public InvalideNameFileExpetion(String message) {
            super("Invalid file name. Please provide a valid file name.", "invalide-name-file");
        }

    }

}
