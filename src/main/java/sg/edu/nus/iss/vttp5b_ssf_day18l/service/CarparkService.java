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
        JsonObject jObject = jReader.readObject();
        JsonArray jArray = jObject.getJsonObject("result").getJsonArray("records");

        List<Carpark> carparks = new ArrayList<>();
        for (int i = 0; i < jArray.size(); i++) {
            Carpark c = new Carpark(jArray.get(i).asJsonObject().getInt("_id"),
                    jArray.get(i).asJsonObject().getString("carpark"),
                    jArray.get(i).asJsonObject().getString("category"),
                    jArray.get(i).asJsonObject().getString("weekdays_rate_1"),
                    jArray.get(i).asJsonObject().getString("weekdays_rate_2"),
                    jArray.get(i).asJsonObject().getString("saturday_rate"),
                    jArray.get(i).asJsonObject().getString("sunday_publicholiday_rate"));
                carparks.add(c);
        }

        return carparks;
    }
}
