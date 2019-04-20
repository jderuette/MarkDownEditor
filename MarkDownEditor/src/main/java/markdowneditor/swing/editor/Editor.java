package markdowneditor.swing.editor;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/**
 *
 * @author Thomas TAVERNIER
 */
public class Editor {
    /** Initialize headerEditorInstance. */
    private HeaderEditor headerInstance;
    /** Initialize textEditorInstance. */
    private TextEditor contentInstance;
    /** Initialize previewInstance. */
    private Preview previewInstance;
    /** Initialize fileName. */
    private JTextPane fileNamePaneInstance;

    /**
     * Editor constructor.
     */
    public Editor() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);

        this.headerInstance = new HeaderEditor();
        this.contentInstance = new TextEditor();
        this.previewInstance = new Preview();
        this.fileNamePaneInstance = new JTextPane();

        this.headerInstance.setBorder(border);
        this.contentInstance.setBorder(border);
        this.previewInstance.setBorder(border);
    }

    /**
     * @return instance of header
     */
    public final HeaderEditor getHeaderEditorInstance() {
        return headerInstance;
    }

    /**
     * @return instance of content
     */
    public final TextEditor getContentEditorInstance() {
        return contentInstance;
    }

    /**
     * @return instance of preview
     */
    public final Preview getPreviewInsatnce() {
        return previewInstance;
    }

    /**
     * @return instance of fileName
     */
    public final JTextPane getFileNameInsatnce() {
        return fileNamePaneInstance;
    }
}
