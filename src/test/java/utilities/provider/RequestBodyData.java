package utilities.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RequestBodyData {

    @DataProvider(name = "issueBody")
    public Object[][] getData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/java/testdata/successCreatedIssueBody.json");
        List<Map<String, Object>> dataList = objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});
        Object[][] testData = new Object[dataList.size()][2];

        for (int i = 0; i < dataList.size(); i++) {
            testData[i][0] = dataList.get(i).get("type");
            testData[i][1] = dataList.get(i).get("summary");
        }
        return testData;
    }

    @DataProvider(name = "invalidIssueBody")
    public Object[][] getInvalidData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/java/testdata/invalidCreateIssueBody.json");
        List<Map<String, Object>> dataList = objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});
        Object[][] testData = new Object[dataList.size()][2];

        for (int i = 0; i < dataList.size(); i++) {
            testData[i][0] = dataList.get(i).get("type");
            testData[i][1] = dataList.get(i).get("summary");
        }
        return testData;
    }

}
