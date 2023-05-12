import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordProbability {

    public static HashMap<String, HashMap<String, Integer>> ProbabilityCountForFile(String[] fileText) {
        HashMap<String, HashMap<String, Integer>> probabilityCountForFile = new HashMap<String, HashMap<String, Integer>>();

        for (int i = 0; i < fileText.length - 1; i ++) {
            HashMap<String, Integer> nextWordProbability = new HashMap<String, Integer>();
            String currentWord = fileText[i];
            String nextWord = fileText[i + 1];

            if (!probabilityCountForFile.containsKey(currentWord)) {
                nextWordProbability.put(nextWord, 1);
                probabilityCountForFile.put(currentWord, nextWordProbability);
            }
            else {
                nextWordProbability = probabilityCountForFile.get(currentWord);

                if (!nextWordProbability.containsKey(nextWord)) {
                    nextWordProbability.put(nextWord, 1);
                    probabilityCountForFile.put(currentWord, nextWordProbability);
                }
                else {
                    nextWordProbability.put(nextWord, nextWordProbability.get(nextWord) + 1);
                    probabilityCountForFile.put(currentWord, nextWordProbability);
                }
            }
        }
        return probabilityCountForFile;
    }


    public static ArrayList<HashMap<String, HashMap<String, Integer>>> ProbabilityForAllFiles(ArrayList<String[]> allFileWords) {
        ArrayList<HashMap<String, HashMap<String, Integer>>> totalProbability = new ArrayList<HashMap<String, HashMap<String, Integer>>>();

        for (String[] wordList : allFileWords) {
            HashMap<String, HashMap<String, Integer>> probabilityForFile = ProbabilityCountForFile(wordList);
            totalProbability.add(probabilityForFile);
        }
        return totalProbability;
    }


    public static void displayProbability(HashMap<String, HashMap<String, Integer>> ProbabilityCountForFile) {
        for (Map.Entry<String, HashMap<String, Integer>> entry : ProbabilityCountForFile.entrySet()) {
            System.out.println(entry.getKey());
            float totalWordCount = 0;
            for (Map.Entry<String, Integer> eachEntry : entry.getValue().entrySet()) {
                totalWordCount = totalWordCount + eachEntry.getValue();
            }

            for (Map.Entry<String, Integer> eachEntry : entry.getValue().entrySet()) {
                float probability = eachEntry.getValue() / totalWordCount;
                System.out.println("    " + eachEntry.getKey() + " " + probability);
            }
        }
    }
}
