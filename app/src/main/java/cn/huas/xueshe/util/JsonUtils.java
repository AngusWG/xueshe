package cn.huas.xueshe.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * json工具类
 */
public class JsonUtils {

    /**
     * 从一个JSON对象字符格式中得到一个java对象
     *
     * @param jsonString
     * @param pojoClass
     * @return
     */
    public static Object getObjectJsonString(String jsonString, Class<?> pojoClass) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Object pojo = JSONObject.toJavaObject(jsonObject, pojoClass);
        return pojo;
    }

    /**
     * 从json数组中得到相应java数组
     *
     * @param jsonString
     * @return
     */
    public static Object[] getObjectArrayJson(String jsonString) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        return jsonArray.toArray();
    }

    /**
     * 将json文本数据信息转化为JsonObject对象，然后用键值对的方式获取
     *
     * @param jsonString json文本
     * @param name       键值对
     * @return String
     */
    public static String jsonToJsonObject(String jsonString, String name) {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return String.valueOf(jsonObject.get(name));
    }

    /**
     * 将一个对象转换为json字符串
     *
     * @param object
     * @return
     */
    public static String getObjectToJsonObject(Object object) {
        return JSON.toJSON(object).toString();
    }

    /**
     * 从json HASH表达式中获取一个map，改map支持嵌套功能
     *
     * @param jsonString
     * @return
     */
    public static Map<String, Object> getMapJson(String jsonString) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Iterator<String> keyIter = jsonObject.keySet().iterator();
        Map<String, Object> valueMap = new HashMap<>();
        while ((keyIter.hasNext())) {
            String key = keyIter.next();
            Object value = jsonObject.get(key);
            valueMap.put(key, value);
        }
        return valueMap;
    }

    /**
     * 从json数组中解析出java字符串数组
     *
     * @param jsonString
     * @return
     */
    public static String[] getStringArrayJson(String jsonString) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        String[] stringArray = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            stringArray[i] = jsonArray.get(i).toString();
        }
        return stringArray;
    }

}
