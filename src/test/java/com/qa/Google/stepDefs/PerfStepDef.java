package com.qa.Google.stepDefs;

import com.qa.Google.utils.StopWatchUtil;
import com.qa.Google.utils.Xls_Reader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class PerfStepDef {
    StopWatchUtil startStopWatch = new StopWatchUtil();
    String scenarioType = null;
    Map<String, Object[]> data = new TreeMap<String, Object[]>();
    Xls_Reader xls = new Xls_Reader("perf_test_output.xlsx");

    String test_run = "Response_Time_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd-hhmmss"))+"(In Sec)";

    @Before
    public void enterPerfData(Scenario scenario) throws Exception {
        scenarioType = scenario.getSourceTagNames().toString();
        data.put("1", new Object[]{"Test Scenarios", "Response Time(s)"});
        if (scenarioType.contains("@Perf")) {
            xls.addColumn("UI_Test_Run", test_run);
        } else if (scenarioType.contains("@APIPerf")) {
            xls.addColumn("Api_Test_Run", test_run);
        }
    }

    @Given("^I log \"([^\"]*)\" start time$")
    public void iLogStartTime(String scenario) {
        startStopWatch.startStopWatch();
    }

    @Then("^I log \"([^\"]*)\" finish time$")
    public void iLogFinishTime(String scenario) {
        if (scenario.contains("OPEN_GOOGLE_PAGE")) {
            startStopWatch.stopStopWatch();
            if (scenarioType.contains("@Perf")) {
                System.out.println(startStopWatch.getStopWatchTime());
                xls.setCellData("UI_Test_Run", test_run, 2, startStopWatch.getStopWatchTime()/1000.0);
            }
        } else if (scenario.contains("SEARCH_TEXT")) {
            startStopWatch.stopStopWatch();
            if (scenarioType.contains("@Perf")) {
                System.out.println(startStopWatch.getStopWatchTime());
                xls.setCellData("UI_Test_Run", test_run, 3, startStopWatch.getStopWatchTime()/1000.0);
            }
        }

    }
}
