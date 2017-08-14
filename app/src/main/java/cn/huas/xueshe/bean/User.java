package cn.huas.xueshe.bean;


public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userSex;

    private String userTel;

    private String userQq;

    private String userEmail;

    private String userLevel;

    private Integer userNum;

    private String userHead;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

//    public String getUserLevel() {
//        return userLevel;
//    }
//
//    public void setUserLevel(String userLevel) {
//        this.userLevel = userLevel == null ? null : userLevel.trim();
//    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead == null ? null : userHead.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userNum=" + userNum +
                ", userHead='" + userHead + '\'' +
                '}';
    }
}