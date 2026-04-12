package Interview.Toptal;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;


class Welcome {
    private long id;
    private String userID;
    private String age;
    private String userWeight;
    private String name;
    private double price;
    private long weight;
    private long calories;
    private double fat;
    private double carbs;
    private double protein;
    private String timeConsumed;
    private LocalDate dateConsumed;
    private String type;
    private String favorite;
    private String procedence;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("user_id")
    public String getUserID() { return userID; }
    @JsonProperty("user_id")
    public void setUserID(String value) { this.userID = value; }

    @JsonProperty("age")
    public String getAge() { return age; }
    @JsonProperty("age")
    public void setAge(String value) { this.age = value; }

    @JsonProperty("user_weight")
    public String getUserWeight() { return userWeight; }
    @JsonProperty("user_weight")
    public void setUserWeight(String value) { this.userWeight = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("price")
    public double getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(double value) { this.price = value; }

    @JsonProperty("weight")
    public long getWeight() { return weight; }
    @JsonProperty("weight")
    public void setWeight(long value) { this.weight = value; }

    @JsonProperty("calories")
    public long getCalories() { return calories; }
    @JsonProperty("calories")
    public void setCalories(long value) { this.calories = value; }

    @JsonProperty("fat")
    public double getFat() { return fat; }
    @JsonProperty("fat")
    public void setFat(double value) { this.fat = value; }

    @JsonProperty("carbs")
    public double getCarbs() { return carbs; }
    @JsonProperty("carbs")
    public void setCarbs(double value) { this.carbs = value; }

    @JsonProperty("protein")
    public double getProtein() { return protein; }
    @JsonProperty("protein")
    public void setProtein(double value) { this.protein = value; }

    @JsonProperty("time_consumed")
    public String getTimeConsumed() { return timeConsumed; }
    @JsonProperty("time_consumed")
    public void setTimeConsumed(String value) { this.timeConsumed = value; }

    @JsonProperty("date_consumed")
    public LocalDate getDateConsumed() { return dateConsumed; }
    @JsonProperty("date_consumed")
    public void setDateConsumed(LocalDate value) { this.dateConsumed = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("favorite")
    public String getFavorite() { return favorite; }
    @JsonProperty("favorite")
    public void setFavorite(String value) { this.favorite = value; }

    @JsonProperty("procedence")
    public String getProcedence() { return procedence; }
    @JsonProperty("procedence")
    public void setProcedence(String value) { this.procedence = value; }
}

