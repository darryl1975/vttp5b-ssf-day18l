package sg.edu.nus.iss.vttp5b_ssf_day18l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vttp5b_ssf_day18l.constant.Constant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    @Qualifier(Constant.template01)
    RedisTemplate<String, String> redisTemplate;

    // day 18 - slide 8
    @GetMapping("/health")
    public ModelAndView getHealth() {
        ModelAndView mav = new ModelAndView();

        try {
            // checkHealth();

            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }

        return mav;
    }

    private void checkHealth() {
        // get random number between 0 and 10

        // if random number is between 0 and 5 
        // throw an exception
        // means there is an exception/error (simulating exception)

        // else do nothing
    }

    @GetMapping("/time")
    public String displayDateTime(Model model) throws ParseException {

        // yyyy-MM-dd HH:mm:ss 1980-07-25 15:30:40
        // yyyy-MMM-dd HH:mm:ss 1980-JUL-25 15:30:40
        // yyyy-MMM-dd hh:mm:ss a 1980-JUL-25 3:30:40 PM"
        String strDate = "1980-07-25 15:30:40";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date demoDate = sdf.parse(strDate);
        long epochMilliseconds = demoDate.getTime();
        Date retrievedDate = new Date(epochMilliseconds);

        model.addAttribute("date", retrievedDate);
        return "time";
    }

    @GetMapping("/test")
    @ResponseBody
    public String testHash() {
        
        List<String> wordList = new ArrayList<>();
        wordList.add("Marina");
        wordList.add("Park");
        wordList.add("Hotel");
        wordList.add("Bridge");
        wordList.add("Merlion");
        wordList.add("Cruise");

        // save the list to hash in redis
        redisTemplate.opsForHash().put("words", "map", wordList.toString());

        // retrieve the list from redis 
        Object objWords = redisTemplate.opsForHash().get("words", "map");

        return objWords.toString();
    }

}
