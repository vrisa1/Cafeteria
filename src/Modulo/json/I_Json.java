package Modulo.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Interface.
 * Contiene metodos para trabajar con Json.
 */
public interface I_Json {
    /**
     * Convierte datos a formato Json.
     * @return - Dato convertido a JsonObject.
     * @throws JSONException
     */
    JSONObject toJSON() throws JSONException;

    /**
     * Convierte JSONObject a datos.
     * @param jsonObject - JsonObject a convertir.
     * @throws JSONException
     */
    void fromJSON(JSONObject jsonObject) throws JSONException;
}
