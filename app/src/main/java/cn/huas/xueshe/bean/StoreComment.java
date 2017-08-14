package cn.huas.xueshe.bean;


public class StoreComment {

    private long commentId;
    private String storeName;
    private String commentScore;
    private long userId;
    private String commentDetail;


    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    public String getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(String commentScore) {
        this.commentScore = commentScore;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

}
