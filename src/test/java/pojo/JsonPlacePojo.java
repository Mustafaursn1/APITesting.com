package pojo;

public class JsonPlacePojo {
    /*
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
            }
    */
    private Integer userId;
    private  String title;
    private Boolean completed;
    private Integer id;

    public JsonPlacePojo(Integer userId, String title, Boolean completed, Integer id) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
        this.id = id;
    }

    public JsonPlacePojo() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JsonPlacePojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }
}
