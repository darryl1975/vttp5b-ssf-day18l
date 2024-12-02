package sg.edu.nus.iss.vttp5b_ssf_day18l.model;

public class Carpark {
    private Integer id;

    private String carpark;

    private String category;

    private String weekday1Rate;

    private String weekday2Rate;

    private String saturdayRate;

    private String sundayPublicHolidayRate;

    public Carpark(Integer id, String carpark, String category, String weekday1Rate, String weekday2Rate,
            String saturdayRate, String sundayPublicHolidayRate) {
        this.id = id;
        this.carpark = carpark;
        this.category = category;
        this.weekday1Rate = weekday1Rate;
        this.weekday2Rate = weekday2Rate;
        this.saturdayRate = saturdayRate;
        this.sundayPublicHolidayRate = sundayPublicHolidayRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarpark() {
        return carpark;
    }

    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeekday1Rate() {
        return weekday1Rate;
    }

    public void setWeekday1Rate(String weekday1Rate) {
        this.weekday1Rate = weekday1Rate;
    }

    public String getWeekday2Rate() {
        return weekday2Rate;
    }

    public void setWeekday2Rate(String weekday2Rate) {
        this.weekday2Rate = weekday2Rate;
    }

    public String getSaturdayRate() {
        return saturdayRate;
    }

    public void setSaturdayRate(String saturdayRate) {
        this.saturdayRate = saturdayRate;
    }

    public String getSundayPublicHolidayRate() {
        return sundayPublicHolidayRate;
    }

    public void setSundayPublicHolidayRate(String sundayPublicHolidayRate) {
        this.sundayPublicHolidayRate = sundayPublicHolidayRate;
    }

    @Override
    public String toString() {
        return id + "," + carpark + "," + category + ","
                + weekday1Rate + "," + weekday2Rate + "," + saturdayRate
                + "," + sundayPublicHolidayRate + "]";
    }

    
    
}
