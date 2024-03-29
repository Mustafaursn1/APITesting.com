package pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiDataPojo {
    /*
    {
        "status": "success",
         "data": {
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image",
             "id": 4891
             }
        "message": "Successfully! Record has been added."
        }
     */

    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;
    private Integer id;


    public DummyRestApiDataPojo(String employee_name, Integer employee_salary, Integer employee_age, String profile_image, Integer id) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.id = id;
    }

    public DummyRestApiDataPojo() {
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DummyRestApiDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", profile_image='" + profile_image + '\'' +
                ", id=" + id +
                '}';
    }
}
