package markdowneditor.swing.editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * @author Thomas TODO.
 *
 */
public class MarkdownJPanel extends JPanel implements KeyListener {
    /** serialVersionUID. */
    private static final long serialVersionUID = 2213277497364439982L;
    /** TODO. */
    private TextEditor textEditor;
    /** TODO. */
    private HeaderEditor headerEditor;
    /** TODO. */
    private Preview preview;

    /**
     *
     * TODO.
     * @param editor TODO
     */
    public MarkdownJPanel(final Editor editor) {
        this.textEditor = editor.getTextEditorInstance();
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
