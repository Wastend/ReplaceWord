import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * This class sets parameters for the graphical window
 *
 */
public class MyFrame extends JFrame implements ActionListener {

    /**
     * path to file
     */
    private Path file = null;
    /**
     * old word
     */
    private JTextField word;
    /**
     * new word
     */
    private JTextField newWord;
    /**
     * button for upload file
     */
    private JButton uploadFile;
    /**
     * button for replace words in text
     */
    private JButton replace;
    /**
     * label for return text from file
     */
    private JLabel result;

    /**
     * window creation constructor
     */
    public MyFrame() {

        JLabel res = new JLabel("Результат замены");
        res.setBounds(130, 130, 120, 30);

        JLabel jLabel = new JLabel("Слово для замены");
        jLabel.setBounds(245, 10, 120, 30);

        uploadFile = new JButton("Загрузить файл");
        uploadFile.setBounds(30, 50, 130, 30);
        uploadFile.addActionListener(this);

        replace = new JButton("Заменить");
        replace.setBounds(30, 90, 130, 30);
        replace.addActionListener(this);

        word = new JTextField();
        word.setBounds(240, 50, 120, 30);

        newWord = new JTextField();
        newWord.setBounds(240, 90, 120, 30);

        result = new JLabel();
        result.setBounds(40, 170, 300, 200);

        this.setTitle("ReplaceWord");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(uploadFile);
        this.add(jLabel);
        this.add(word);
        this.add(newWord);
        this.add(res);
        this.add(replace);
        this.add(result);
        this.setResizable(false);
        this.setSize(400, 400);
        this.setVisible(true);

    }

    /**
     * A method that regulates the behavior of the program after pressing a certain button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * replaceWord - object of class ReplaceWord
         */
        ReplaceWord replaceWord = new ReplaceWord();
        /**
         * if pressed uploadFile button
         */
        if (e.getSource() == uploadFile) {
            try {
                file = replaceWord.chooseFile();
                if (file.equals(null)) throw new Exception();
            } catch (Exception E) {
                result.setText("Вы не выбрали файл");
            }
        }
        /**
         * if pressed replace button
         */
        if (e.getSource() == replace) {
            try {
                String str = replaceWord.readText(file);
                result.setText("<html>" + replaceWord.replaseWord(file, str, word.getText(), newWord.getText()) + "</html>");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (NullPointerException ex) {
                result.setText("Невозможно сделать замену. Файл не выбран");
            }
        }
    }
}
