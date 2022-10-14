import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReplaceWord {
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

    public String readText(Path path) throws IOException {
        Scanner scannerFile = new Scanner(path).useDelimiter("\\Z");
        return scannerFile.next();
    }

    public String replaseWord(Path path,String text, String word, String replaceWord) throws IOException {
        text = text.replace(word,replaceWord);
        Files.write(path,text.getBytes());
        return text;
    }

}
