package sg.edu.nus.iss.vttp5b_ssf_day18l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5b_ssf_day18l.model.Person;
import sg.edu.nus.iss.vttp5b_ssf_day18l.repo.ListRepo;

@Service
public class PersonService {
    
    @Autowired
    ListRepo listRepo;

    public void createPerson(Person p) {
        listRepo.rightPush("persons", p.toString());
    }

    public List<Person> getPersons(String redisKey) {
        List<String> personString = listRepo.getList(redisKey);

        List<Person> persons = new ArrayList<>();

        for (String s: personString) {
            String [] personArray = s.split(",");
            Person p = new Person(Integer.parseInt(personArray[0]), personArray[1], personArray[2], personArray[3], personArray[4]);
            persons.add(p);
        }

        return persons;
    }
}
