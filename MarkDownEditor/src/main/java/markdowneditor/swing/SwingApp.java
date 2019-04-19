package markdowneditor.swing;

import markdowneditor.swing.editor.Window;

/**
 * @author Thomas TAVERNIER
 */
abstract class SwingApp {
    /**
     * @param args TODO
     */
    public static void main(final String[] args) {
        @SuppressWarnings("unused")
        Window window = new Window();
    }
}
