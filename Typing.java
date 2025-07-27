import java.util.Scanner;

public class Typing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String sentence = "The quick brown fox jumps over the lazy dog";

        System.out.println("Welcome to the Typing Speed Test Program!");

        System.out.println("-------------");

        System.out.println("Type the following sentence as fast and accurately as you can:");

        System.out.println("\n" + sentence);

        System.out.println("\n Press Enter to start...");

        scanner.nextLine(); 

                    // Start time

        long startTime = System.currentTimeMillis();

        System.out.println("Start typing now:");

        String input = scanner.nextLine();  

                   // End time
        long endTime = System.currentTimeMillis();

        
        double timeTaken = (endTime - startTime) / 1000.0;

        
        int wordCount = sentence.split("\\s+").length;

        double wpm = (wordCount / timeTaken) * 60;

        
        int errors = calculateErrors(sentence, input);

        System.out.println("\n--- Results ---");
        System.out.printf("Time Taken: %.2f seconds\n", timeTaken);
        System.out.printf("Typing Speed: %.2f words per minute (WPM)\n", wpm);
        System.out.println("Errors: " + errors);

        scanner.close();
    }

    
    public static int calculateErrors(String original, String typed) {
        int errors = 0;
        int minLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) != typed.charAt(i)) {
                errors++;
            }
        }

       
        errors += Math.abs(original.length() - typed.length());
        return errors;
    }
}