package markdowneditor.swing.editor;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 *
 * @author Thomas TAVERNIER
 */
public class MainJPanel extends JPanel {
    /** serialVersionUID. */
    private static final long serialVersionUID = -5361829940344666623L;
    /** Initialize markdownJPanel. */
    private MarkdownJPanel markdownJPanel;
    /** Initialize fileSelectorMenu. */
    private FileSelectorMenu fileSelectorMenu;

    /**
     * FileSelectorMenu constructor.
     *
     * @param editor set editor instance
     */
    public MainJPanel(final Editor editor) {
        this.markdownJPanel = new MarkdownJPanel(editor);
        this.fileSelectorMenu = new FileSelectorMenu(editor);
        this.setLayout(new BorderLayout());
        this.add(this.fileSelectorMenu, BorderLayout.NORTH);
        this.add(this.markdownJPanel, BorderLayout.CENTER);
    }
}
