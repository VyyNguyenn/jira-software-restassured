package utilities;

import io.restassured.http.Header;
import java.util.Base64;

public interface RequestCapabilities {
    String email = System.getenv("email");
    String token = "ATATT3xFfGF0Bljd6NmGJtUzjyOetW4BAgySnezvcJpxJJr9bt4uxULUitWE_kaCoFsIQ74ETaphaiX9cBPt4kiAC6BGpYE_BCdLCn1TrtAzmquZ2kg0fypyw38Tgpv8k_lTeEpVTbJ_LkiSp2teAg4BDr6GZV38euc-kYhdLfrcxeqEGitWsnA=3DAA6414";
    String cred = email.concat(":").concat(token);
    String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    String PROJECT_ID = "10002";

    Header contentTypeHeader = new Header("Content-Type", "application/json");
    Header acceptHeader = new Header("Accept", "application/json");
    Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);


}