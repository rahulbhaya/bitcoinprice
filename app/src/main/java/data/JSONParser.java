package data;

import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Bitcoin;

/**
 * Created by rahulbhaya on 10/15/17.
 */

public class JSONParser {
    public static Bitcoin getBitcoinPrice(String data){

        Bitcoin bitcoin = new Bitcoin();
        try {
            JSONObject obj = new JSONObject(data);
            JSONObject jsonBitcoin = obj.getJSONObject("USD");
            System.out.println(jsonBitcoin.getString("symbol"));
            bitcoin.setPrice15m(Utils.getFloat("15m", jsonBitcoin));
            bitcoin.setLast(Utils.getFloat("last", jsonBitcoin));
            bitcoin.setBuy(Utils.getFloat("buy", jsonBitcoin));
            bitcoin.setSell(Utils.getFloat("sell", jsonBitcoin));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bitcoin;
    }
}
