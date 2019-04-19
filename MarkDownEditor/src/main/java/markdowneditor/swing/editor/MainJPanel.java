package markdowneditor.swing.editor;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Thomas TAVERNIER
 *
 */
public class MainJPanel extends JPanel {
    /** serialVersionUID. */
    private static final long serialVersionUID = -5361829940344666623L;

    /**
     * TODO.
     * @param editor TODO
     */
    public MainJPanel(final Editor editor) {

        MarkdownJPanel markdownJPanel = new MarkdownJPanel(editor);
        FileSelectorMenu fileSelectorMenu = new FileSelectorMenu();

        this.setLayout(new BorderLayout());
        this.add(fileSelectorMenu, BorderLayout.NORTH);
        this.add(markdownJPanel, BorderLayout.CENTER);
        //TODO tata by Djer |Evol| Affiche le nom du fichier actuellement édité dans le SOUTH ? 
    }
}
