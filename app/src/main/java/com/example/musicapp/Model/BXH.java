package com.example.musicapp.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BXH {

    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private Integer status;
    @SerializedName("data")
    private List<Data> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public class Data implements Serializable {


        @SerializedName("Id")
        private int id;
        @SerializedName("Ten")
        private String ten;
        @SerializedName("Hinhanh")
        private String hinhanh;
        @SerializedName("Icon")
        private String icon;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getHinhanh() {
            return hinhanh;
        }

        public void setHinhanh(String hinhanh) {
            this.hinhanh = hinhanh;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }


}


