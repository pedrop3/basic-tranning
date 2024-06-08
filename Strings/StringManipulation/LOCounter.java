package Strings.StringManipulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LOCounter {
    public static int countLines(String filePath) throws IOException {
        int codeLines = 0;
        boolean inBlockComment = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing whitespace

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Handle single line comments
                if (line.startsWith("//")) {
                    continue;
                }

                // Handle block comments
                if (line.startsWith("/*")) {
                    inBlockComment = true;
                } else if (line.endsWith("*/")) {
                    inBlockComment = false;
                }

                if (!inBlockComment) {
                    codeLines++;
                }
            }
        }

        return codeLines;
    }

    public static void main(String[] args) throws IOException {
     
 
        int codeLines = countLines("/home/pedrosantos/workspace/estudos/basic-tranning/Strings/StringManipulation/Example.java");
        System.out.println("Number of code lines: " + codeLines);
    }

}
