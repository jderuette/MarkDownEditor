package markdowneditor.swing.editor;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import markdowneditor.swing.service.Manager;

/**
 * Main JFrame.
 *
 * @author Thomas TAVERNIER
 */
public class Window extends JFrame {
    /** serialVersionUID. */
    private static final long serialVersionUID = 5754128319161534792L;
    /** Initialize SCRENNSIZE. */
    private static final Dimension SCRENNSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    /** Initialize editor. */
    private Editor editor;
    /** Initialize toDTO. */
    private Manager manager;

    /**
     * FileSelectorMenu constructor.
     */
    public Window() {
        this.editor = new Editor();
        this.manager = new Manager(editor);
        MainJMenu mainMenu = new MainJMenu(manager);
        this.setJMenuBar(mainMenu);

        MainJPanel mainPanel = new MainJPanel(editor);
        this.add(mainPanel);
        this.setSize(SCRENNSIZE.width / 2, SCRENNSIZE.height / 2);
        this.setLocationRelativeTo(null);
        this.setTitle("MarkDown Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
