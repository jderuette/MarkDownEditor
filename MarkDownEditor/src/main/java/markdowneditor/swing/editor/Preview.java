package markdowneditor.swing.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.Timer;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

/**
 *
 * @author Thomas TAVERNIER
 */
public class Preview extends JEditorPane implements ActionListener {
    /** serialVersionUID. */
    private static final long serialVersionUID = -8924868132574681604L;
    /** Initialize parser. */
    private static Parser parser;
    /** Initialize renderer. */
    private static HtmlRenderer renderer;
    /** Initialize text. */
    private String text;
    /** Initialize timer. */
    private Timer timer;
    /** Initialize WAIT. */
    private static final Integer WAIT = 1000;

    /**
     * Preview constructor.
     */
    public Preview() {
        this.timer = new Timer(WAIT, this);
        this.setContentType("text/html");
        MutableDataSet options = new MutableDataSet();
        parser = Parser.builder(options).build();
        renderer = HtmlRenderer.builder(options).build();
    }

    /**
     * @param textSet set text
     */
    public void convert(final String textSet) {
        this.text = textSet;
        timer.start();
    }

    /**
     * render the MarkDown in HTML.
     */
    public void render() {
        String print = renderer.render(parser.parse(text));
        this.setText(print);
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {
        timer.stop();
        render();
    }
}
