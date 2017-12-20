package data.operations;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFiles {
    private static Logger log = LogConfig.getLoger(ReadFiles.class);

    public List<FilesDataStore> getFilesDetailsFromPath(String folderPath)  {
        List<File> filesPath = readFilesFromDirectory(folderPath);
        List<FilesDataStore> filesDetails = new ArrayList<>();
        for(int i = 0; i < filesPath.size(); i++) {
            File filePath = filesPath.get(i);
            filesDetails.add(new FilesDataStore(
                    filePath,
                    getMimeType(filePath),
                    String.valueOf(filePath.length()), //file size in bytes
                    filePath.getName().split("\\.")[0], //file name
                    filePath.getName().split("\\.")[1])); //file extension
        }
        return filesDetails;
    }


    public List<File> readFilesFromDirectory(String folderPath) {
        List<File> filesInFolder = new ArrayList<>();
        try {
            filesInFolder = Files.walk(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("An error occured when trying to read from directory");
            e.printStackTrace();
        }
        log.info("Found " + filesInFolder.size() + " files on: " + folderPath);
        return filesInFolder;
    }


    public String getMimeType(File filePath) {
        String mimeType = "unknown";
        try {
            mimeType = Magic.getMagicMatch(filePath, true, true).getMimeType();
        }
        catch (MagicParseException e) {
           e.printStackTrace();
        }
        catch (MagicMatchNotFoundException e) {
            e.printStackTrace();
        }
        catch (MagicException e) {
            e.printStackTrace();
        }
        return mimeType;
    }


    public List<FilesDataStore>getFilesDetailsByMimeType (String mimeType, String folderPath) {
        List<FilesDataStore> filesDetails = getFilesDetailsFromPath(folderPath);
        List<FilesDataStore> filteredList = new ArrayList<>();
        for (int i = 0; i < filesDetails.size(); i++) {
            if (filesDetails.get(i).getMimeType().equalsIgnoreCase(mimeType)) {
                filteredList.add(filesDetails.get(i));
            }
        }
        log.info("Found " + filteredList.size() + " files filtered by mime: " + mimeType);
        return filteredList;
    }


    public List<FilesDataStore>getFilesDetailsByExtension (String fileExt, String folderPath) {
        List<FilesDataStore> filesDetails = getFilesDetailsFromPath(folderPath);
        List<FilesDataStore> filteredList = new ArrayList<>();
        for (int i = 0; i < filesDetails.size(); i++) {
            if (filesDetails.get(i).getFileExtension().equalsIgnoreCase(fileExt)) {
                filteredList.add(filesDetails.get(i));
            }
        }
        log.info("Found " + filteredList.size() + " files filtered by extension: " + fileExt);
        return filteredList;
    }
}
