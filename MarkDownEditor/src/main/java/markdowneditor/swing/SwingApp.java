package markdowneditor.swing;

import markdowneditor.swing.editor.Window;

/**
 *
 * @author Thomas TAVERNIER
 */
abstract class SwingApp {

    /**
     * Starting point.
     *
     * @param args put parameters.
     */
    public static void main(final String[] args) {
        @SuppressWarnings("unused")
        Window window = new Window();
    }
}
