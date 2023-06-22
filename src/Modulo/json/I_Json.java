package Modulo.json;

import org.json.JSONException;
import org.json.JSONObject;

public interface I_Json {
    JSONObject toJSON() throws JSONException;
    void fromJSON(JSONObject jsonObject) throws JSONException;
}
