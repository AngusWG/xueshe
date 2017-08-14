package cn.huas.xueshe.config;

public class APIAddress {
    public static final String BASIC_API_URL = "http://xueshe.96xm.cn:8080";

    //登陆
    public static final String LOGIN_URL = BASIC_API_URL + "/user/login";

    //注册
    public static final String REGISTER_URL = BASIC_API_URL + "/user/register";

    //退出

    public static final String LOGOUT = BASIC_API_URL + "/user/logout";

    //查询用户
    public static final String userInfo(String userId) {
        return BASIC_API_URL + "/user/getUserInfo/userId=" + userId;
    }

    //活动新建
    public static final String ADD_ACITIVITY_URL = BASIC_API_URL + "/activity/addActivity";

    //活动查询帖子
    public static final String GETACTIVITY(String activityId) {
        return BASIC_API_URL + "/activity/getActivity/activityId=" + activityId;
    }

    //活动列表查询
    public static final String GETACTIVITYLIST = BASIC_API_URL + "/activity/getActivityList";

    //活动添加评论
    public static final String ADDACTIVITYCOMMENT = BASIC_API_URL + "activityComment/addActivityComment";

}
