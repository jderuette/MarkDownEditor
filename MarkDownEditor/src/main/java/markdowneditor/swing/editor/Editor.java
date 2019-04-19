package markdowneditor.swing.editor;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author Thomas TAVERNIER
 *
 */
public class Editor {
    /** TODO. */
    private HeaderEditor headerEditorInstance;
    /** TODO. */
    private TextEditor textEditorInstance;
    /** TODO. */
    private Preview preview;

    /** TODO. */
    public Editor() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);

        this.headerEditorInstance = new HeaderEditor();
        this.textEditorInstance = new TextEditor();
        this.preview = new Preview();

        this.headerEditorInstance.setBorder(border);
        this.textEditorInstance.setBorder(border);
        this.preview.setBorder(border);
    }

    /**
     * @return TODO
     */
    public final HeaderEditor getHeaderEditorInstance() {
        return headerEditorInstance;
    }

    /**
     * @return TODO
     */
    public final TextEditor getTextEditorInstance() {
        return textEditorInstance;
    }

    /**
     * @return TODO
     */
    public final Preview getPreviewInsatnce() {
        return preview;
    }
}
