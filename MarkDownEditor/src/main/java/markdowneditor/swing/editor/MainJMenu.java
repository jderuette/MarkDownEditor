package markdowneditor.swing.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author Thomas TAVERNIER
 *
 */
public class MainJMenu extends JMenuBar implements ActionListener {
    /** TODO. */
    private static final long serialVersionUID = 8454523963742057316L;
    /** TODO. */
    private TextEditor textEditor;
    /** TODO. */
    private HeaderEditor headerEditor;
    /** TODO. */
    private Preview preview;

    /**
     * TODO.
     *
     * @param editor TODO
     */
    public MainJMenu(final Editor editor) {
        this.textEditor = editor.getTextEditorInstance();
        this.headerEditor = editor.getHeaderEditorInstance();
        this.preview = editor.getPreviewInsatnce();

        JMenu file = new JMenu("File");

        JMenuItem mNew = new JMenuItem("New");
        JMenuItem mOpen = new JMenuItem("Open");
        JMenuItem mSave = new JMenuItem("Save");

        mNew.addActionListener(this);
        mOpen.addActionListener(this);
        mSave.addActionListener(this);

        file.add(mNew);
        file.add(mOpen);
        file.add(mSave);

        this.add(file);
    }

    /**
     * TODO.
     *
     * @param event TODO
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        String source = event.getActionCommand();

        switch (source) {
        case "New":
            //TODO Tat by Djer |POO| pas de SysSout sur un serveur ! Utilise une LOG
            System.out.println("new");
            break;
        case "Open":
            //TODO Tat by Djer |POO| pas de SysSout sur un serveur ! Utilise une LOG
            System.out.println("open");
            // Create an object of JFileChooser class
            JFileChooser fileChooser = new JFileChooser();
            // Invoke the showsOpenDialog function to show the save dialog
            int filChoosen = fileChooser.showOpenDialog(null);
            // If the user selects a file
            if (filChoosen == JFileChooser.APPROVE_OPTION) {
                // Set the label to the path of the selected directory
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                //TODO Tat by Djer |POO| Tu aurais intéret à créer un DTO pour stocker la structure d'un "JBake document" (Header et content)
                //TODO Tat by Djer |POO| Tu pourrais avoir un service responsable d'interpreter un "file" (ou équivalent) et de le transformer en DTO "facilement" manipulable par le Swing
                String separator = "~~~~~~";
                Boolean swap = true;

                try {
                    String header = "";
                    String text = "";
                    String line = "";
                    BufferedReader in;
                    in = new BufferedReader(new FileReader(file));
                    line = in.readLine();
                    while (line != null) {
                        if (line.equals(separator)) {
                            swap = !swap;
                            text = in.readLine();
                        } else if (swap) {
                            if (header.equals("")) {
                                header = line;
                            } else {
                                header = header + "\n" + line;
                            }
                        } else {
                            text = text + "\n" + line;
                        }
                        line = in.readLine();
                    }
                    in.close();
                    // Set the text
                    headerEditor.setText(header);
                    textEditor.setText(text);
                    preview.convert(text);
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(this, evt.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "the user cancelled the operation");
            }
            break;
        case "Save":
          //TODO Tat by Djer |POO| pas de SysSout sur un serveur ! Utilise une LOG
            System.out.println("save");
            break;
        default:
          //TODO Tat by Djer |POO| pas de SysSout sur un serveur ! Utilise une LOG
            System.out.println("no match");
        }
    }
}
