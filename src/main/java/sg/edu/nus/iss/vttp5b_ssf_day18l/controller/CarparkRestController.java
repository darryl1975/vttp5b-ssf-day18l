package sg.edu.nus.iss.vttp5b_ssf_day18l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5b_ssf_day18l.model.Carpark;
import sg.edu.nus.iss.vttp5b_ssf_day18l.service.CarparkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/carparks")
public class CarparkRestController {
    
    @Autowired
    CarparkService carparkService;

    @GetMapping("")
    public ResponseEntity<List<Carpark>> getCarparks() { // List<Carpark>
        List<Carpark> carparks = carparkService.getCarparks();
        
        // return new ResponseEntity<>(carparks, HttpStatus.OK);
        return ResponseEntity.ok().body(carparks);
    }
    

}
