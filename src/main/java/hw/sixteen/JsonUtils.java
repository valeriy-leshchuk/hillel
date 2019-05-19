package hw.sixteen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtils
{
    public static JSONArray getOrCreateArray(JSONObject json, String name)
    {
        JSONArray result;
        try
        {
            result = json.getJSONArray(name);
        }
        catch (JSONException ex)
        {
            result = new JSONArray();
            json.put(name, result);
        }
        return result;
    }

    private JsonUtils()
    {
    }
}
