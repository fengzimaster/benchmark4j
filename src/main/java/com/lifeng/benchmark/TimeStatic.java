package com.lifeng.benchmark;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/22/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class TimeStatic {
    public Long getConnectStartTime() {
        return connectStartTime;
    }

    public void setConnectStartTime(Long connectStartTime) {
        this.connectStartTime = connectStartTime;
    }

    public Long getConnectEndTime() {
        return connectEndTime;
    }

    public void setConnectEndTime(Long connectEndTime) {
        this.connectEndTime = connectEndTime;
    }

    public Long getWriteRequestTime() {
        return writeRequestTime;
    }

    public void setWriteRequestTime(Long writeRequestTime) {
        this.writeRequestTime = writeRequestTime;
    }

    public Long getResponceTime() {
        return responceTime;
    }

    public void setResponceTime(Long responceTime) {
        this.responceTime = responceTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getConnetTime() {
        return connetTime;
    }

    public void setConnetTime(Long connetTime) {
        this.connetTime = connetTime;
    }

    public Long getResponcetime() {
        return responcetime;
    }

    public void setResponcetime(Long responcetime) {
        this.responcetime = responcetime;
    }

    private Long connectStartTime;
    private Long connectEndTime;
    private Long writeRequestTime;
    private Long responceTime;
    private String url;
    private String status;
    private Long connetTime;
    private Long responcetime;


}
