package com.example.musicapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Album {
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
        @SerializedName("IdAlbum")
        private int Id;

        @SerializedName("TenAlbum")
        private String TenAlbum;

        @SerializedName("TenCaSiAlbum")
        private String TenCaSiAlbum;

        @SerializedName("HinhAlbum")
        private String HinhAlbum;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getTenAlbum() {
            return TenAlbum;
        }

        public void setTenAlbum(String tenAlbum) {
            TenAlbum = tenAlbum;
        }

        public String getTenCaSiAlbum() {
            return TenCaSiAlbum;
        }

        public void setTenCaSiAlbum(String tenCaSiAlbum) {
            TenCaSiAlbum = tenCaSiAlbum;
        }

        public String getHinhAlbum() {
            return HinhAlbum;
        }

        public void setHinhAlbum(String hinhAlbum) {
            HinhAlbum = hinhAlbum;
        }




    }
}
