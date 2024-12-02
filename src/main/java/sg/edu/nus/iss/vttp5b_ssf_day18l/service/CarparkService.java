package sg.edu.nus.iss.vttp5b_ssf_day18l.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.vttp5b_ssf_day18l.constant.Constant;
import sg.edu.nus.iss.vttp5b_ssf_day18l.model.Carpark;

@Service
public class CarparkService {

    RestTemplate restTemplate = new RestTemplate();

    public List<Carpark> getCarparks() {

        String carparkRawData = restTemplate.getForObject(Constant.carparkUrl, String.class);

        JsonReader jReader = Json.createReader(new StringReader(carparkRawData));
        JsonObject jObject = jReader.readObject(); // the entire json string
        JsonObject jResultObject = jObject.getJsonObject("result"); // the result object inside the entire json string
                                                                    // (object)

        JsonArray jArray = jResultObject.getJsonArray("records");

        List<Carpark> carparks = new ArrayList<>();
        for (int i = 0; i < jArray.size(); i++) {
            JsonObject j = jArray.get(i).asJsonObject();

            Carpark c = new Carpark(j.getInt("_id"),
                    j.getString("carpark"),
                    j.getString("category"),
                    j.getString("weekdays_rate_1"),
                    j.getString("weekdays_rate_2"),
                    j.getString("saturday_rate"),
                    j.getString("sunday_publicholiday_rate"));
            carparks.add(c);
        }

        return carparks;
    }
}
