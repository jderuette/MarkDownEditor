package markdowneditor.swing.editor;

import javax.swing.JEditorPane;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

/**
 * @author Thomas TAVERNIER
 *
 */
public class Preview extends JEditorPane {
    /** TODO. */
    private static final long serialVersionUID = -8924868132574681604L;
    /** TODO. */
    private static Parser parser;
    /** TODO. */
    private static HtmlRenderer renderer;

    /** TODO. */
    public Preview() {
        this.setContentType("text/html");
        MutableDataSet options = new MutableDataSet();
        parser = Parser.builder(options).build();
        renderer = HtmlRenderer.builder(options).build();
    }

    /**
     * TODO.
     *
     * @param text TODO
     */
    public void convert(final String text) {
        String print = renderer.render(parser.parse(text));
        this.setText(print);
        System.out.println(print);
    }
}
