package pojo;

public class GoRestPojo {
    private Object meta;//obje olsa daha iyi olur
    private GoRestDataPojo data;

    public GoRestPojo(String meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestPojo() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestMetaPojo{" +
                "meta='" + meta + '\'' +
                ", data=" + data +
                '}';
    }
}
