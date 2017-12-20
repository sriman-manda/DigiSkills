package data.tests;

import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.operations.FilesDataStore;
import data.operations.ReadFiles;
import framework.CarDataStructure;
import org.testng.Assert;
import org.testng.annotations.Guice;

import java.util.ArrayList;
import java.util.List;
@Guice
public class TestDataFiles {
    @Inject ReadFiles rf;
    private static List<FilesDataStore> fd = new ArrayList<>();
    private static Scenario scenario;
    private static String filesPath;
    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^I read all files from path \"([^\"]*)\"$")
    public void readAllFilesFromPath(String filesPath) {
        this.filesPath = filesPath;
        fd = rf.getFilesDetailsFromPath(filesPath);
        Assert.assertTrue(fd.size() > 0, "No files found on: " + filesPath);
    }

    @Then("^A report is created with all received details$")
    public void createReportWithAllReceivedDetails() {
        scenario.write("Name   Extension   Size   Mime Type");
        for (int i = 0; i < fd.size(); i++) {
            scenario.write(fd.get(i).getFileName() + "      "
                    + fd.get(i).getFileExtension() + "      "
                    + fd.get(i).getFileByteSize() + "      "
                    + fd.get(i).getMimeType() + "   ");
        }
    }

    @When("^I filter the files based on supported mime type \"([^\"]*)\"$")
    public void filterFilesByMimeType(String mimeType) {
        fd = rf.getFilesDetailsByMimeType(mimeType, filesPath);
        Assert.assertTrue(fd.size() > 0, "No files found filtered by mime type: " + mimeType);
        scenario.write("Supported files filtered by mime: " + mimeType);
    }

    @Then("^A report is created listing only the supported files$")
    public void createReportWithSupportedFiles() {
        for (int i = 0; i < fd.size(); i++) {
            scenario.write(fd.get(i).getFileName() + "."
                    + fd.get(i).getFileExtension());
        }
    }


}
