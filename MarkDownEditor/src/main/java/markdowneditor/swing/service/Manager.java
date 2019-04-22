package markdowneditor.swing.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import markdowneditor.swing.editor.Editor;

/**
 * Manages the DTO and the JtextArea texts.
 *
 * @author Thomas TAVERNIER
 */
public class Manager extends DTO {
    /** serialVersionUID. */
    private static final long serialVersionUID = 3762155276957759749L;
    /** Initialize editor. */
    private Editor editor;
    /** Initialize MARKDOWN_DELIMITER. */
    private static final String MARKDOWN_DELIMITER = "~~~~~~";
    /** Initialize DELETE_FILE_EXTENSION. */
    private static final Integer DELETE_FILE_EXTENSION = 3;

    /**
     * ToDTO constructor.
     *
     * @param editorInstance set editor instance
     */
    public Manager(final Editor editorInstance) {
        this.editor = editorInstance;
    }

    /**
     * convert the markdown into DTO.
     *
     * @param fileChoosen file choosen
     */
    public void convert(final JFileChooser fileChoosen) {
        String fileName = fileChoosen.getSelectedFile().getName();
        String filePath = fileChoosen.getSelectedFile().getParentFile().toString();
        if (fileName.endsWith(".md")) {
            fileName = fileName.substring(0, fileName.length() - DELETE_FILE_EXTENSION);
        }
        setFileName(fileName);
        setFilePath(filePath);
        File file = new File(getFileAbsolutePath());
        try {
            Scanner scan = new Scanner(file);
            scan.useDelimiter(MARKDOWN_DELIMITER);
            if (scan.hasNext()) {
                setHeaderText(scan.next());
                if (scan.hasNext()) {
                    setContentText(scan.next());
                }
            } else {
                setHeaderText("");
                setContentText("");
            }
            scan.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * write text from DTO.
     */
    public void write() {
        getEditor().getFileNameInsatnce().setText(getFileName());
        getEditor().getHeaderEditorInstance().setText(getHeaderText());
        getEditor().getContentEditorInstance().setText(getContentText());
        getEditor().getPreviewInsatnce().convert(getContentText());

        getEditor().getFileNameInsatnce().setEditable(true);
        getEditor().getHeaderEditorInstance().setEditable(true);
        getEditor().getContentEditorInstance().setEditable(true);
    }

    /**
     * save text to file.
     */
    public void save() {
        File oldFile = new File(getFileAbsolutePath());

        setFileName(getEditor().getFileNameInsatnce().getText());

        System.err.println(getEditor().getHeaderEditorInstance().getText());
        if (getEditor().getHeaderEditorInstance().getText().equals("")) {
            setHeaderText(" ");
        } else {
            setHeaderText(getEditor().getHeaderEditorInstance().getText());
        }
        setContentText(getEditor().getContentEditorInstance().getText());

        File newFile = new File(getFileAbsolutePath());
        getEditor().getFileNameInsatnce().setText(getFileName());
        if (!oldFile.getAbsolutePath().equals(newFile.getAbsolutePath()) && newFile.exists()) {
            if (JOptionPane.showConfirmDialog(null, "File already exist, erase it ?", "File already exist",
                    JOptionPane.YES_NO_CANCEL_OPTION) != 0) {
                return;
            }
        }
        try {
            if (!oldFile.renameTo(newFile)) {
                oldFile.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            writer.write(getHeaderText());
            writer.append(MARKDOWN_DELIMITER);
            writer.append(getContentText());
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * create a new file.
     *
     * @param fileChooser file chosen
     */
    public void createFile(final JFileChooser fileChooser) {
        File createFile = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".md");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(createFile));
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @return editor instance
     */
    public Editor getEditor() {
        return editor;
    }

    /**
     * Chek if file exist.
     *
     * @param fileChooser selected file
     *
     * @return true if file doesn't exist
     */
    public boolean checkIfFileExist(final JFileChooser fileChooser) {
        File fileToCheck = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".md");
        return fileToCheck.exists();
    }
}
