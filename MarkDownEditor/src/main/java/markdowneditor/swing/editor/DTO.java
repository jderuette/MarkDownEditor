package markdowneditor.swing.editor;

import java.io.Serializable;

/**
 *
 * @author Thomas TAVERNIER
 */
public class DTO implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = -4904609167303842009L;
    /** Initialize fileName. */
    private String fileName = "";
    /** Initialize filePath. */
    private String filePath;
    /** Initialize headerText. */
    private String headerText = "";
    /** Initialize contentText. */
    private String contentText = "";

    /**
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @return header text
     */
    public String getHeaderText() {
        return headerText;
    }

    /**
     * @return content text
     */
    public String getContentText() {
        return contentText;
    }

    /**
     * @return build file absolute path
     */
    public String getFileAbsolutePath() {
        return filePath + "\\" + fileName + ".md";
    }

    /**
     * @param fileNameSet set file name
     */
    public void setFileName(final String fileNameSet) {
        this.fileName = fileNameSet.replaceAll("[^A-Za-z0-9]", "");
    }

    /**
     * @param filePathSet set file path
     */
    public void setFilePath(final String filePathSet) {
        this.filePath = filePathSet;
    }

    /**
     * @param headerSetText set header text
     */
    public void setHeaderText(final String headerSetText) {
        this.headerText = headerSetText;
    }

    /**
     * @param contentSetText content text
     */
    public void setContentText(final String contentSetText) {
        this.contentText = contentSetText;
    }
}
