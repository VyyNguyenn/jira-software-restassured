package builder;

import com.google.gson.Gson;

public class BodyJsonBuilder {

    public static <T> String getJsonData(T dataObject){
        return new Gson().toJson(dataObject);
    }
}
