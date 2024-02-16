package com.example.musicapp.Model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Banner{
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

    public static class Data implements Serializable{
        @SerializedName("Id")
        private int Id;

        @SerializedName("HinhAnh")
        private String HinhAnh;

        @SerializedName("NoiDung")
        private String NoiDung;

        @SerializedName("Idbaihat")
        private String Idbaihat;

        @SerializedName("TenBaiHat")
        private String TenBaiHat;

        @SerializedName("HinhBaiHat")
        private String HinhBaiHat;


        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getHinhAnh() {
            return HinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
            HinhAnh = hinhAnh;
        }

        public String getNoiDung() {
            return NoiDung;
        }

        public void setNoiDung(String noiDung) {
            NoiDung = noiDung;
        }

        public String getIdbaihat() {
            return Idbaihat;
        }

        public void setIdbaihat(String idbaihat) {
            Idbaihat = idbaihat;
        }

        public String getTenBaiHat() {
            return TenBaiHat;
        }

        public void setTenBaiHat(String tenBaiHat) {
            TenBaiHat = tenBaiHat;
        }

        public String getHinhBaiHat() {
            return HinhBaiHat;
        }

        public void setHinhBaiHat(String hinhBaiHat) {
            HinhBaiHat = hinhBaiHat;
        }
    }
}