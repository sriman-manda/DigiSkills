package data.operations;

import java.io.File;

public class FilesDataStore {
    private String mimeType;
    private String fileByteSize;
    private String fileName;
    private String fileExtension;
    private File filePath;

    public FilesDataStore(File filepath, String mimeType, String fileByteSize, String fileName, String fileExtension) {
        this.filePath = filepath;
        this.mimeType = mimeType;
        this.fileByteSize = fileByteSize;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public File getFilePath() {
        return filePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getFileByteSize() {
        return fileByteSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }



}
