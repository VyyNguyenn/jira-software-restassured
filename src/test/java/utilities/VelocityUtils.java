package utilities;

import org.apache.velocity.VelocityContext;

public class VelocityUtils {

    VelocityContext context = new VelocityContext();
    public void getRandomString(int length){
        context.put("$randomString", new BaseTest());
    }
}
