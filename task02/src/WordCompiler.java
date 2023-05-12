import java.io.*;
import java.util.ArrayList;

public class WordCompiler {

    public static String[] FolderCompiler(String directory) {
        File files = new File(directory);
        return files.list();
    }


    public static ArrayList<String> directoryFiles(String directoryName) {
        File directory = new File(directoryName);
        ArrayList<String> fileNames = new ArrayList<String>();
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(directoryName + File.separator + file.getName());
            }
        }
        return fileNames;
    }


    public static String[] TextFileReader(String textFile) throws Exception{
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        ArrayList<String> fileWords = new ArrayList<String>();

        while ((line = br.readLine()) != null) {
            if (line.length() == 0) {
                continue;
            }
            line = line.replaceAll("[^a-zA-Z0-9\\s]", "");
            String[] words = line.split(" ");
            for (String word : words) {
                word = word.toLowerCase().trim();
                fileWords.add(word);
            }
        }
        br.close();
        fr.close();

        String[] allFileWords = new String[fileWords.size()];

        for (int i = 0; i < fileWords.size(); i++) {
            allFileWords[i] = fileWords.get(i);
        }
        return allFileWords;
    }


    public ArrayList<String[]> WordCompilation(String directoryName) throws Exception{
        File directory = new File(directoryName);
        ArrayList<String> files = directoryFiles(directoryName);
        ArrayList<String[]> allWords = new ArrayList<String[]>();

        for (String file : files) {
            String[] words = TextFileReader(file);
            allWords.add(words);
        }
        return allWords;
    }

}
