package com.ghh.springcloudcusterm.utils;

/**
 * @className: ResultUtils
 * @description: 封装结果类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-17 10:48
 **/
public class ResultUtils {

    /**
     * 返回码
     */
    private String resultCode;

    /**
     * 返回消息
     */
    private String resultInfo;

    /**
     * 返回数据
     */
    private Object resultData;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "ResultUtils{" +
                "resultCode='" + resultCode + '\'' +
                ", resultInfo='" + resultInfo + '\'' +
                ", resultData=" + resultData +
                '}';
    }
}
