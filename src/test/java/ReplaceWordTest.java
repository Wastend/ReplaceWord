import org.junit.Test;


import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.*;
/**
 * The class contains methods for testing methods ReplaceWord.java
 */
public class ReplaceWordTest {
    /**
     * replaceWord - object of ReplaceWord
     */
    ReplaceWord replaceWord = new ReplaceWord();
    @Test
    /**
     * readTextTest tests the readText method in the class ReplaceWord
     */
    public void readTextTest() throws IOException {
        Path path1 = Path.of("src/main/java/test1.txt").toAbsolutePath();
        Path path2 = Path.of("src/main/java/test2.txt").toAbsolutePath();
        String str1 = "Этот текст был создан специально для тестирования замены текст";
        String str2 = "Что же лучше, теория или практика?\r\nСкорее всего лучшее все сразу.\r\nНо практика больше.";
        assertEquals(str1,replaceWord.readText(path1));
        assertEquals(str2,replaceWord.readText(path2));
    }

    /**
     * replaceWordTest tests the replaseWord method in the class ReplaceWord
     */
    @Test
    public void replaceWordTest() throws IOException {
        Path path1 = Path.of("src/main/java/test1.txt").toAbsolutePath();
        String text1 = "Этот текст был создан специально для тестирования замены текст";
        String result1 = "Этот якобы текст был создан специально для тестирования замены якобы текст";
        String word1 = "текст";
        String replaceWord1 = "якобы текст";
        Path path2 = Path.of("src/main/java/test2.txt").toAbsolutePath();;
        String text2 = "Что же лучше, теория или практика?\r\nСкорее всего лучшее все сразу.\r\nНо практика больше.";
        String result2 = "Что же лучше, теория или ничего?\r\nСкорее всего лучшее все сразу.\r\nНо ничего больше.";
        String word2 = "практика";
        String replaceWord2 = "ничего";
        assertEquals(result1,replaceWord.replaseWord(path1,text1,word1,replaceWord1));
        assertEquals(result2,replaceWord.replaseWord(path2,text2,word2,replaceWord2));
    }

}