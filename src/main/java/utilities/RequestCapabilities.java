package utilities;

import io.restassured.http.Header;
import java.util.Base64;

public interface RequestCapabilities {
    String email = "vytn101@gmail.com";
    String token = "ATATT3xFfGF0jb-u9Wd73mm43ql1_ktzYgz71WkgdJhd955cY51Wlgtp-8nr4gCc1ajYV-jW3OimNv2b51J619eVKckIpNXOSDTovuQe9VTe_39lLOvkzuP32uxQAdarbPTaj7JvgUixaKZ32e-57Kfi5LC9yS_YtQm-aREPFq1iZfZFwWX9pgM=A95CDC7C";
    String cred = email.concat(":").concat(token);
    String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    String PROJECT_ID = "10002";

    Header contentTypeHeader = new Header("Content-Type", "application/json");
    Header acceptHeader = new Header("Accept", "application/json");
    Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);


}