package markdowneditor.swing.editor;

import javax.swing.JTextArea;

/**
 * Header JTextArea.
 *
 * @author Thomas TAVERNIER
 */
public class HeaderEditor extends JTextArea {
    /** serialVersionUID. */
    private static final long serialVersionUID = 4609138648351807051L;

    /**
     * HeaderEditor constructor.
     */
    public HeaderEditor() {
        this.setLineWrap(true);
        this.setEditable(false);
    }
}
