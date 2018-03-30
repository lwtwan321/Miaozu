package sandbox.easylinks.com.miaozu.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
