import java.io.Serializable;

public class MyURL implements Serializable {
    public String describe;
    public String urlString;

    public MyURL(String describe, String urlString) {
        this.describe = describe;
        this.urlString = urlString;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }
}