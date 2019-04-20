package markdowneditor.swing.editor;

import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Thomas TAVERNIER
 */
public class FileSelectorMenu extends JPanel {
    /** serialVersionUID. */
    private static final long serialVersionUID = -3037509437113168210L;

    /**
     * FileSelectorMenu constructor.
     *
     * @param editoInstance set editor instance
     */
    public FileSelectorMenu(final Editor editoInstance) {
        this.add(editoInstance.getFileNameInsatnce());
        JTextPane fileExtensionPane = new JTextPane();
        fileExtensionPane.setText(".md");
        fileExtensionPane.setEditable(false);
        this.add(fileExtensionPane);
    }
}
