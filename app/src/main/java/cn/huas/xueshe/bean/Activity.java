package cn.huas.xueshe.bean;

public class Activity {
    private long activityId;
    private long userId;
    private long activityCreateDate;
    private String activityTitle;
    private String activityDescribtion;

    public long getActivityId() {
        return activityId;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", userId=" + userId +
                ", activityCreateDate=" + activityCreateDate +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityDescribtion='" + activityDescribtion + '\'' +
                ", activityExpectJoiner=" + activityExpectJoiner +
                ", activityJoiner=" + activityJoiner +
                ", activityQq='" + activityQq + '\'' +
                ", activityJoinerTable='" + activityJoinerTable + '\'' +
                ", activityClickRate=" + activityClickRate +
                ", activityInterest=" + activityInterest +
                ", activityAddress='" + activityAddress + '\'' +
                ", activityExpected=" + activityExpected +
                ", activityExisting=" + activityExisting +
                ", activityPhone=" + activityPhone +
                ", activityStartDate=" + activityStartDate +
                ", activityEndDate=" + activityEndDate +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getActivityCreateDate() {
        return activityCreateDate;
    }

    public void setActivityCreateDate(long activityCreateDate) {
        this.activityCreateDate = activityCreateDate;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDescribtion() {
        return activityDescribtion;
    }

    public void setActivityDescribtion(String activityDescribtion) {
        this.activityDescribtion = activityDescribtion;
    }

    public long getActivityExpectJoiner() {
        return activityExpectJoiner;
    }

    public void setActivityExpectJoiner(long activityExpectJoiner) {
        this.activityExpectJoiner = activityExpectJoiner;
    }

    public long getActivityJoiner() {
        return activityJoiner;
    }

    public void setActivityJoiner(long activityJoiner) {
        this.activityJoiner = activityJoiner;
    }

    public String getActivityQq() {
        return activityQq;
    }

    public void setActivityQq(String activityQq) {
        this.activityQq = activityQq;
    }

    public String getActivityJoinerTable() {
        return activityJoinerTable;
    }

    public void setActivityJoinerTable(String activityJoinerTable) {
        this.activityJoinerTable = activityJoinerTable;
    }

    public long getActivityClickRate() {
        return activityClickRate;
    }

    public void setActivityClickRate(long activityClickRate) {
        this.activityClickRate = activityClickRate;
    }

    public long getActivityInterest() {
        return activityInterest;
    }

    public void setActivityInterest(long activityInterest) {
        this.activityInterest = activityInterest;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public long getActivityExpected() {
        return activityExpected;
    }

    public void setActivityExpected(long activityExpected) {
        this.activityExpected = activityExpected;
    }

    public long getActivityExisting() {
        return activityExisting;
    }

    public void setActivityExisting(long activityExisting) {
        this.activityExisting = activityExisting;
    }

    public long getActivityPhone() {
        return activityPhone;
    }

    public void setActivityPhone(long activityPhone) {
        this.activityPhone = activityPhone;
    }

    public long getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(long activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

    public long getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(long activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    private long activityExpectJoiner;
    private long activityJoiner;
    private String activityQq;
    private String activityJoinerTable;
    private long activityClickRate;
    private long activityInterest;
    private String activityAddress;
    private long activityExpected;
    private long activityExisting;
    private long activityPhone;
    private long activityStartDate;
    private long activityEndDate;
}