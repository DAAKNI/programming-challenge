package de.exxcellent.challenge.Models;

import de.exxcellent.challenge.Config.FileType;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper class for the file that's beeing read. Lines in a file are getting added as Strings in a list;
 */
public class FileWrapper {
    private String fileName;
    private FileType fileType;
    private List<String> fileData = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public List<String> getFileData() {
        return fileData;
    }

    public void setFileData(List<String> fileData) {
        this.fileData = fileData;
    }
}
