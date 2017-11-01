package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rahulbhaya on 10/15/17.
 */

public class Utils {
    public static final String JSON_URL= "https://blockchain.info/ticker";
    //public static final String JSON_URL = "https://api.coindesk.com/v1/bpi/currentprice/USD.json";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException{

        return jsonObject;
    }
    public static String getString(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagName);

    }
    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException{
        return (float)jsonObject.getDouble(tagName);

    }
    public static float getInt(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagName);

    }
}

