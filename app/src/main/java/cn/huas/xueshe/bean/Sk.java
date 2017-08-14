package cn.huas.xueshe.bean;


public class Sk {

    private long skId;
    private String skTitle;
    private String skDescribtion;
    private String skGets;
    private String skWants;
    private String skQq;
    private String skTel;
    private java.sql.Timestamp skCreatedate;
    private long userNum;
    private long skClickRate;


    public long getSkId() {
        return skId;
    }

    public void setSkId(long skId) {
        this.skId = skId;
    }


    public String getSkTitle() {
        return skTitle;
    }

    public void setSkTitle(String skTitle) {
        this.skTitle = skTitle;
    }


    public String getSkDescribtion() {
        return skDescribtion;
    }

    public void setSkDescribtion(String skDescribtion) {
        this.skDescribtion = skDescribtion;
    }


    public String getSkGets() {
        return skGets;
    }

    public void setSkGets(String skGets) {
        this.skGets = skGets;
    }


    public String getSkWants() {
        return skWants;
    }

    public void setSkWants(String skWants) {
        this.skWants = skWants;
    }


    public String getSkQq() {
        return skQq;
    }

    public void setSkQq(String skQq) {
        this.skQq = skQq;
    }


    public String getSkTel() {
        return skTel;
    }

    public void setSkTel(String skTel) {
        this.skTel = skTel;
    }


    public java.sql.Timestamp getSkCreatedate() {
        return skCreatedate;
    }

    public void setSkCreatedate(java.sql.Timestamp skCreatedate) {
        this.skCreatedate = skCreatedate;
    }


    public long getUserNum() {
        return userNum;
    }

    public void setUserNum(long userNum) {
        this.userNum = userNum;
    }


    public long getSkClickRate() {
        return skClickRate;
    }

    public void setSkClickRate(long skClickRate) {
        this.skClickRate = skClickRate;
    }

}
