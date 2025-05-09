import java.util.HashMap;
import java.util.Map;

 public class LipogramAnalyzer {

    private String text;

    // Constructor to initialize the text
    public LipogramAnalyzer(String text) {
        this.text = text;
    }

    // Method to mark 'e' and 'E' in the text with '#'
    public String mark() {
        // Replace both 'e' and 'E' with '#'
        return this.text.replaceAll("[eE]", "#");
    }

    // Method to find offending words and return them with their counts
    public String allWordsWith() {
        Map<String, Integer> offendingWords = new HashMap<>();
        
        // Split the text into words using a regular expression to handle any non-alphabetic characters
        String[] words = this.text.split("[^a-zA-Z]+");
        
        for (String word : words) {
            word = word.toLowerCase();
            if (!word.isEmpty() && word.contains("e")) {
                // Increment the count of the offending word in the map
                offendingWords.put(word, offendingWords.getOrDefault(word, 0) + 1);
            }
        }

        // Build the result string with each offending word and its count
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : offendingWords.entrySet()) {
            result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return result.toString();
    }
}