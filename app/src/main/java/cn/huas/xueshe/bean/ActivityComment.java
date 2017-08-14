package cn.huas.xueshe.bean;


public class ActivityComment {

    private long acId;
    private long commentDate;
    private long userId;
    private String commentDescription;
    private long activityId;


    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }


    public long getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(long commentDate) {
        this.commentDate = commentDate;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }


    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

}
