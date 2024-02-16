package com.example.musicapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Baihatyeuthich {
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

    public static class Data implements Parcelable {
        @SerializedName("Idbaihat")
        private int Id;

        @SerializedName("Tenbaihat")
        private String Tenbaihat;

        @SerializedName("Hinhbaihat")
        private String Hinhbaihat;

        @SerializedName("Casi")
        private String Casi;

        @SerializedName("Linkbaihat")
        private String Linkbaihat;

        @SerializedName("Luotthich")
        private int Luotthich;

        protected Data(Parcel in) {
            Id = in.readInt();
            Tenbaihat = in.readString();
            Hinhbaihat = in.readString();
            Casi = in.readString();
            Linkbaihat = in.readString();
            Luotthich = in.readInt();
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getTenbaihat() {
            return Tenbaihat;
        }

        public void setTenbaihat(String tenbaihat) {
            Tenbaihat = tenbaihat;
        }

        public String getHinhbaihat() {
            return Hinhbaihat;
        }

        public void setHinhbaihat(String hinhbaihat) {
            Hinhbaihat = hinhbaihat;
        }

        public String getCasi() {
            return Casi;
        }

        public void setCasi(String casi) {
            Casi = casi;
        }

        public String getLinkbaihat() {
            return Linkbaihat;
        }

        public void setLinkbaihat(String linkbaihat) {
            Linkbaihat = linkbaihat;
        }

        public int getLuotthich() {
            return Luotthich;
        }

        public void setLuotthich(int luotthich) {
            Luotthich = luotthich;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(Id);
            parcel.writeString(Tenbaihat);
            parcel.writeString(Hinhbaihat);
            parcel.writeString(Casi);
            parcel.writeString(Linkbaihat);
            parcel.writeInt(Luotthich);
        }
    }
}
