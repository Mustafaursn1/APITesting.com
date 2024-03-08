package pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//response da olup burda olmayan datayi ignore etmek icin bu anatotion lullanilir
public class JsonPlaceHolderPojo {
    /*
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
            }
    */
    private Integer userId;
    private String title;
    private Boolean completed;


    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;

    }

    public JsonPlaceHolderPojo() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


    @Override
    public String toString() {
        return "JsonPlacePojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
