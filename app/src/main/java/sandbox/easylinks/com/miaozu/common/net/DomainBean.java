package sandbox.easylinks.com.miaozu.common.net;

public class DomainBean {

    private static String instanceDomain;
    private static String imageDomain;
    private static String crmDomain;
    private static String mobileWeb;
    private static String mUlr;

    public static void defineDomainModel(
            String instanceDomain,
            String imageDomain,
            String crmDomain,
            String mobileWeb,
            String mUlr) {
        setInstanceDomain(instanceDomain);
        setImageDomain(imageDomain);
        setCrmDomain(crmDomain);
        setMobileWeb(mobileWeb);
        setmUlr(mUlr);
    }

    public static String getInstanceDomain() {
        return instanceDomain;
    }

    public static void setInstanceDomain(String instanceDomain) {
        DomainBean.instanceDomain = instanceDomain;
    }

    public static String getImageDomain() {
        return imageDomain;
    }

    public static void setImageDomain(String imageDomain) {
        DomainBean.imageDomain = imageDomain;
    }

    public static String getCrmDomain() {
        return crmDomain;
    }

    public static void setCrmDomain(String crmDomain) {
        DomainBean.crmDomain = crmDomain;
    }

    public static String getMobileWeb() {
        return mobileWeb;
    }

    public static void setMobileWeb(String mobileWeb) {
        DomainBean.mobileWeb = mobileWeb;
    }

    public static String getmUlr() {
        return mUlr;
    }

    public static void setmUlr(String mUlr) {
        DomainBean.mUlr = mUlr;
    }
}
