package pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyResponseBodyForDelete {
    /*
    {
        "status": "success",
            "data": "2",
            "message": "Successfully! Record has been deleted"
    }

     */

    private  String status;
    private  Integer data;
    private  String message;

    public DummyResponseBodyForDelete(String status, Integer data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyResponseBodyForDelete() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyResponseBodyForDelete{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
