package markdowneditor.swing.editor;

import javax.swing.JTextArea;

/**
 * Content JTextArea.
 *
 * @author Thomas TAVERNIER
 */
public class TextEditor extends JTextArea {
    /** serialVersionUID. */
    private static final long serialVersionUID = 3543067034994664255L;

    /**
     * TextEditor constructor.
     */
    public TextEditor() {
        this.setLineWrap(true);
        this.setEditable(false);
    }
}
