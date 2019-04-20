package markdowneditor.swing.editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 *
 * @author Thomas TAVERNIER
 */
public class MarkdownJPanel extends JPanel implements KeyListener {
    /** serialVersionUID. */
    private static final long serialVersionUID = 2213277497364439982L;
    /** Initialize textEditor. */
    private TextEditor textEditor;
    /** Initialize headerEditor. */
    private HeaderEditor headerEditor;
    /** Initialize preview. */
    private Preview preview;

    /**
     * MarkdownJPanel constructor.
     *
     * @param editor set editor instance
     */
    public MarkdownJPanel(final Editor editor) {
        this.textEditor = editor.getContentEditorInstance();
        this.headerEditor = editor.getHeaderEditorInstance();
        this.preview = editor.getPreviewInsatnce();

        textEditor.addKeyListener(this);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        center.add(textEditor);
        center.add(preview);
        this.setLayout(new BorderLayout());

        this.add(headerEditor, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
    }

    @Override
    public final void keyTyped(final KeyEvent event) {

    }

    @Override
    public final void keyPressed(final KeyEvent event) {

    }

    @Override
    public final void keyReleased(final KeyEvent event) {
        preview.convert(((TextEditor) event.getSource()).getText());
    }
}
