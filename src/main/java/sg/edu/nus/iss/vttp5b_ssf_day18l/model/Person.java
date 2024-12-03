package sg.edu.nus.iss.vttp5b_ssf_day18l.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

    private Integer id;

    // required - size between 5 characters and 150 characters
    @NotEmpty(message = "First Name is mandatory")
    @Size(min = 5, max = 150, message = "First Name must be between 5 to 60 characters")
    private String fullName;

    // required and must be email format
    @Email(message = "Email input doesn't not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    // between 111111 and 888888
    @Digits(fraction = 0, integer = 6, message = "Postal code must be 6 digits")
    @Min(value = 111111, message = "Postal Code starts from 111111")
    @Max(value = 999999, message = "Postal Code cannot exceed 999999")
    private String postalCode;

    // 7 digits number only - use regular expression
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Phone number must start with 8 or 9 follow by 7 digits")
    private String phoneNumber;

    
    public Person() {
    }

    public Person(Integer id, String fullName, String email, String postalCode, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "{ " +
            "\"id\": " + id + "," +
            "\"fullName\": \"" + fullName + "\"," + 
            "\"email\": \"" + email + "\"," + 
            "\"postalCode\": \"" + postalCode + "\"," + 
            "\"phoneNumber\": \"" + phoneNumber + "\"" +
            "}";
    }

    
    
}
