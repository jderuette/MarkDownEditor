package markdowneditor.swing.editor;

import javax.swing.JFrame;

/**
 * @author Thomas TODO
 */
public class Window extends JFrame {
    /** serialVersionUID. */
    private static final long serialVersionUID = 5754128319161534792L;

    /** TODO. */
    private static final Integer SIZE = 500;

    /** TODO. */
    private Editor editor = new Editor();

    /**
     * TODO.
     */
    public Window() {
        MainJMenu mainMenu = new MainJMenu(editor);
        this.setJMenuBar(mainMenu);

        MainJPanel mainPanel = new MainJPanel(editor);
        this.add(mainPanel);

        this.setSize(SIZE, SIZE);
        this.setLocationRelativeTo(null);
        this.setTitle("MarkDown Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
