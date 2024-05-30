package modelos;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import java.util.Map;

public class MonedaOmdb {
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

}

