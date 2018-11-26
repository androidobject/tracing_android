package com.zzg.tracing.net;

import java.io.Serializable;

/**
 * Created by apple on 2017/12/19.
 * 基础bean
 */

public class BaseBean implements Serializable {

    private Status status;
    //返回值
    private String data;

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    class Status {
        //  [success | failed],布尔值返回时, 也可直接由此判断
        private String state;
        //错误消息
        private String message;
        //时间戳
        private String time;


        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


}
