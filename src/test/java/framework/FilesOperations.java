package framework;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilesOperations {
    private static Logger log = LogConfig.getLoger(FilesOperations.class);

    public List<List<String>> readExcellFile(File filePath) {
        List<List<String>> rowsData = new ArrayList<>();
        XSSFWorkbook myWorkBook = null;
        try {
            myWorkBook = new XSSFWorkbook(new FileInputStream(filePath)); // Read xlsx file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get first Sheet
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);

        // Traversing over each row of XLSX file
        Iterator<Row> rowIterator = mySheet.iterator();

        rowIterator.next(); //skip first row which contains table header
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next(); // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            List<String> cellsData= new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cellsData.add(cell.getStringCellValue()); //add cell value to the list
            }
            rowsData.add(cellsData);
        }
        log.info("Found " + rowsData.size() + " entries for file: " + filePath.getName());
        return rowsData;
    }


    public List<CarDataStructure> getCarsDetailsFromExcellFile(File filePath) {
        List<List<String>> rowsList = readExcellFile(filePath);
        List<CarDataStructure> carsList = new ArrayList<>();
        for (int i = 0; i < rowsList.size(); i++) {
            carsList.add(new CarDataStructure(
                    rowsList.get(i).get(0),
                    rowsList.get(i).get(1),
                    rowsList.get(i).get(2)));
        }
        return carsList;
    }


}
