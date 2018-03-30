package sandbox.easylinks.com.miaozu.common.net;

public enum ServerUrl {

    POST_LOGIN("");

    private String subUrl;

    ServerUrl(String subUrl) {
        this.subUrl = subUrl;
    }

    public String getAction() {
        return subUrl.toString();
    }


}
