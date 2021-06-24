package com.xeant.retrofit.json;

import com.google.gson.annotations.SerializedName;



// 결과를 받을 모델
public class ResultModel {
    @SerializedName("message")
    private String message;
    @SerializedName("error")
    private Integer error;
    @SerializedName("sendcore")
    private Sendcore sendcore;

    private SendArray sendArray;


    public Sendcore getSendcore() {
        return sendcore;
    }

    public void setSendcore(Sendcore sendcore) {
        this.sendcore = sendcore;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "message='" + message + '\'' +
                ", error=" + error +
                ", sendcore=" + sendcore.toString() +
                '}';
    }

    public Integer getError() {
        return error;
    }
    public void setError(Integer error2) {
        this.error = error2;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public class Sendcore {
        @SerializedName("api_key")
        private String api_key;
        @SerializedName("api_secret")
        private String api_secret;
        @SerializedName("my_number")
        private String my_number;
        @SerializedName("discord_webhook")
        private String discord_webhook;
        @SerializedName("discord_avatar")
        private String discord_avatar;
        @SerializedName("discord_name")
        private String discord_name;
        @SerializedName("slack_webhook")
        private String slack_webhook;
        @SerializedName("module_srl")
        private Integer module_srl;

        @Override
        public String toString() {
            return "Sendcore{" +
                    "api_key='" + api_key + '\'' +
                    ", api_secret='" + api_secret + '\'' +
                    ", my_number='" + my_number + '\'' +
                    ", discord_webhook='" + discord_webhook + '\'' +
                    ", discord_avatar='" + discord_avatar + '\'' +
                    ", discord_name='" + discord_name + '\'' +
                    ", slack_webhook='" + slack_webhook + '\'' +
                    ", module_srl=" + module_srl +
                    '}';
        }
        public String getApi_key() {
            return api_key;
        }

        public void setApi_key(String api_key) {
            this.api_key = api_key;
        }

        public String getApi_secret() {
            return api_secret;
        }

        public void setApi_secret(String api_secret) {
            this.api_secret = api_secret;
        }

        public String getMy_number() {
            return my_number;
        }

        public void setMy_number(String my_number) {
            this.my_number = my_number;
        }

        public String getDiscord_webhook() {
            return discord_webhook;
        }

        public void setDiscord_webhook(String discord_webhook) {
            this.discord_webhook = discord_webhook;
        }

        public String getDiscord_avatar() {
            return discord_avatar;
        }

        public void setDiscord_avatar(String discord_avatar) {
            this.discord_avatar = discord_avatar;
        }

        public String getDiscord_name() {
            return discord_name;
        }

        public void setDiscord_name(String discord_name) {
            this.discord_name = discord_name;
        }

        public String getSlack_webhook() {
            return slack_webhook;
        }

        public void setSlack_webhook(String slack_webhook) {
            this.slack_webhook = slack_webhook;
        }

        public Integer getModule_srl() {
            return module_srl;
        }

        public void setModule_srl(Integer module_srl) {
            this.module_srl = module_srl;
        }
    }

    public class SendArray{

    }
}


