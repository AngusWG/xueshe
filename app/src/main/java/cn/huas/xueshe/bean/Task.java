package cn.huas.xueshe.bean;


public class Task {

    private long taskNum;
    private long userId;
    private String taskClass;
    private String taskPrice;
    private String taskTitle;
    private String taskSketch;
    private String taskName;
    private String taskTelephone;
    private java.sql.Timestamp taskStarttime;
    private java.sql.Timestamp taskEndtime;


    public long getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(long taskNum) {
        this.taskNum = taskNum;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getTaskClass() {
        return taskClass;
    }

    public void setTaskClass(String taskClass) {
        this.taskClass = taskClass;
    }


    public String getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(String taskPrice) {
        this.taskPrice = taskPrice;
    }


    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }


    public String getTaskSketch() {
        return taskSketch;
    }

    public void setTaskSketch(String taskSketch) {
        this.taskSketch = taskSketch;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public String getTaskTelephone() {
        return taskTelephone;
    }

    public void setTaskTelephone(String taskTelephone) {
        this.taskTelephone = taskTelephone;
    }


    public java.sql.Timestamp getTaskStarttime() {
        return taskStarttime;
    }

    public void setTaskStarttime(java.sql.Timestamp taskStarttime) {
        this.taskStarttime = taskStarttime;
    }


    public java.sql.Timestamp getTaskEndtime() {
        return taskEndtime;
    }

    public void setTaskEndtime(java.sql.Timestamp taskEndtime) {
        this.taskEndtime = taskEndtime;
    }

}
