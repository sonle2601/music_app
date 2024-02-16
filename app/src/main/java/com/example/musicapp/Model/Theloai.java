package com.example.musicapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Theloai {
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

    public class Data implements Serializable{


        @SerializedName("IdTheLoai")
        private int idTheloai;
        @SerializedName("IdChuDe")
        private int idChude;
        @SerializedName("TenTheLoai")
        private String ten;
        @SerializedName("HinhTheLoai")
        private String hinhanh;

        public int getIdTheloai() {
            return idTheloai;
        }

        public void setIdTheloai(int idTheloai) {
            this.idTheloai = idTheloai;
        }

        public int getIdChude() {
            return idChude;
        }

        public void setIdChude(int idChude) {
            this.idChude = idChude;
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
    }
}