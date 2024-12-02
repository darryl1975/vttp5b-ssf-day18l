package sg.edu.nus.iss.vttp5b_ssf_day18l.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import sg.edu.nus.iss.vttp5b_ssf_day18l.constant.*;
import sg.edu.nus.iss.vttp5b_ssf_day18l.model.Carpark;

@Controller
@RequestMapping("/carparks")
public class CarparkController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    public String carparkList(Model model) {
        List<Carpark> carparks = restTemplate.exchange(Constant.localCarparkUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Carpark>>() {
                }).getBody();

        model.addAttribute("carparks", carparks);
        return "carparks";
    }
}
