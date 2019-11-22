package com.hrms.utils;

import java.util.HashMap;

/**
 * @author doddd
 * @date 2019/11/19-15:36
 **/
//处理Json格式信息  减少请求
public class JsonMsg {
    private int code;//状态码 成功：100 失败：200
    private String msg;//操作信息
    private HashMap<String,Object> extendInfo =new HashMap<String, Object>();//填充返回信息

    public JsonMsg(int code, String msg, HashMap<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extendInfo = extend;
    }
    public JsonMsg() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(HashMap<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public static JsonMsg success(){
        JsonMsg json=new JsonMsg();
        json.setCode(100);
        json.setMsg("操作成功");
        return  json;
    }

    public static JsonMsg fail(){
        JsonMsg json=new JsonMsg();
        json.setCode(200);
        json.setMsg("操作失败");
        return  json;
    }

    public JsonMsg addInfo(String key,Object value){
        this.extendInfo.put(key,value);
        return this;
    }

}
