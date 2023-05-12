import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        String directory = args[0];
        WordCompiler solution = new WordCompiler();
        ArrayList<String[]> allWords = solution.WordCompilation(directory);

        ArrayList<HashMap<String, HashMap<String, Integer>>> wordCount = WordProbability.ProbabilityForAllFiles(allWords);

        for (HashMap<String, HashMap<String, Integer>> words : wordCount) {
            WordProbability.displayProbability(words);
        }
    }
}
