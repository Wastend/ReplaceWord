import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * a class that contains the logic of word permutation
 */
public class ReplaceWord {
    /**
     * The method selects the file to read
     * @return If the file is in txt format, it will return the path, otherwise null
     */
    public Path chooseFile(){
        JFileChooser fileopen = new JFileChooser(".");
        while (true){
            fileopen.showDialog(null, "Открыть файл");
            Path path =  fileopen.getSelectedFile().toPath();
            String str1 = String.valueOf(path);
            String[] str = str1.split("\\.");
            if (str[1].equals("txt") ) return path;
            else return null;
        }
    }

    /**
     * This method read text from file
     * @param path - path to file
     * @return - return text from file
     * @throws IOException
     */
    public String readText(Path path) throws IOException {
        Scanner scannerFile = new Scanner(path).useDelimiter("\\Z");
        return scannerFile.next();
    }

    /**
     * method method replaces the words in the file
     * @param path path to file
     * @param text text from this file
     * @param word word to replace
     * @param replaceWord word that will be replaced
     * @return new text file
     * @throws IOException
     */
    public String replaseWord(Path path,String text, String word, String replaceWord) throws IOException {
        text = text.replace(word,replaceWord);
        Files.write(path,text.getBytes());
        return text;
    }

}
