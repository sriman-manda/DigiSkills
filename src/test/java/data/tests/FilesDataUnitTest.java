package data.tests;

import data.operations.FilesDataStore;
import data.operations.ReadFiles;
import framework.CarDataStructure;
import framework.FilesOperations;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;



public class FilesDataUnitTest {
    private static final String FOLDERS_PATH = "src/main/resources/carsDataFiles" ;

    @Test
    public void testSomething () {
        ReadFiles readFiles = new ReadFiles();
        List<FilesDataStore> filesDetails = readFiles.getFilesDetailsFromPath(FOLDERS_PATH);
        assertTrue(filesDetails.size() != 0);
    }


    @Test
    public void readCarDetailsFromExcellFile() {
        ReadFiles readFiles = new ReadFiles();
        List<FilesDataStore> filesDetails = readFiles.getFilesDetailsFromPath(FOLDERS_PATH);
        List<CarDataStructure> carsData = new ArrayList<>();
        for(int i =0; i < filesDetails.size(); i++ ) {
            if(filesDetails.get(i).getFileExtension().contains("xlsx")) {
                FilesOperations fo = new FilesOperations();
                carsData =(fo.getCarsDetailsFromExcellFile(filesDetails.get(i).getFilePath()));
            }
        }
        for(int i = 0; i < carsData.size(); i++) {
            assertTrue(carsData.get(i).getRegistrationNumber() != null, "Registration number is NULL");
            assertTrue(carsData.get(i).getColour() != null, "Colour value is NULL");
            assertTrue(carsData.get(i).getMake() != null, "Make value is NULL");
        }
    }


    @Test
    public void filterFilesDetails() {
        ReadFiles rf = new ReadFiles();
        List<FilesDataStore> files = rf.getFilesDetailsByMimeType("text/plain", FOLDERS_PATH);
        for(int i = 0; i < files.size(); i++) {
            assertTrue(files.get(i).getFileExtension() != null, "File exension is NULL");
            assertTrue(files.get(i).getFilePath() != null, "File Path is NULL");
            assertTrue(files.get(i).getMimeType() != null, "Mime Type is NULL");
            assertTrue(files.get(i).getFileByteSize() != null, "File Size is NULL");
            assertTrue(files.get(i).getFileName() != null, "File name is NULL");
        }
    }
}
