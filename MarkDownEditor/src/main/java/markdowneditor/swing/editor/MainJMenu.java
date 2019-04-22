package markdowneditor.swing.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import markdowneditor.swing.service.Manager;

/**
 * JMenuBar.
 *
 * @author Thomas TAVERNIER
 */
public class MainJMenu extends JMenuBar implements ActionListener {
    /** serialVersionUID. */
    private static final long serialVersionUID = 8454523963742057316L;
    /** Initialize serviceInstance. */
    private Manager manager;
    /** Initialize fileChooser. */
    private JFileChooser fileChooser;

    /**
     * /** FileSelectorMenu constructor.
     *
     * @param managerInstance set toDTO instance
     */
    public MainJMenu(final Manager managerInstance) {
        this.manager = managerInstance;
        // Create an object of JFileChooser class
        this.fileChooser = new JFileChooser();
        this.fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MarkDown", "md"));
        this.fileChooser.setAcceptAllFileFilterUsed(false);
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
     * Chek if a file has been chosen.
     *
     * @return true if a file has been chosen
     */
    public boolean checkIfAFileIsChosen() {
        Boolean aFileIsChosen = false;
        // Invoke the showsOpenDialog function to show the save dialog
        int fileChosen = fileChooser.showOpenDialog(null);
        // If the user selects a file
        if (fileChosen == JFileChooser.APPROVE_OPTION) {
            aFileIsChosen = true;
        }
        return aFileIsChosen;
    }

    /**
     * action performedd actions.
     *
     * @param event source of action performed
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        String source = event.getActionCommand();
        switch (source) {
        case "New":
            fileChooser.setDialogTitle("New file");
            if (checkIfAFileIsChosen()) {
                if (!manager.checkIfFileExist(fileChooser)) {
                    manager.createFile(fileChooser);
                    manager.convert(fileChooser);
                    manager.write();
                    JOptionPane.showMessageDialog(this,
                            "The file \"" + manager.getFileName() + "\" has been correctly created in \""
                                    + manager.getFilePath() + "\"",
                            "file created", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "The file already exist", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
            break;
        case "Open":
            fileChooser.setDialogTitle("Open");
            if (checkIfAFileIsChosen()) {
                manager.convert(fileChooser);
                manager.write();
            }
            break;
        case "Save":
            manager.save();
            break;
        default:
            break;
        }
    }
}
