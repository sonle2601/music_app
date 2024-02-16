package com.example.musicapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Taikhoan {
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Data> data;
    @SerializedName("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Data implements Serializable {
        @SerializedName("Id")
        private int Id;

        @SerializedName("Tendangnhap")
        private String Tendangnhap;

        @SerializedName("Matkhau")
        private String Matkhau;

        @SerializedName("Ten")
        private String Ten;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getTendangnhap() {
            return Tendangnhap;
        }

        public void setTendangnhap(String tendangnhap) {
            Tendangnhap = tendangnhap;
        }

        public String getMatkhau() {
            return Matkhau;
        }

        public void setMatkhau(String matkhau) {
            Matkhau = matkhau;
        }

        public String getTen() {
            return Ten;
        }

        public void setTen(String ten) {
            Ten = ten;
        }
    }
}
