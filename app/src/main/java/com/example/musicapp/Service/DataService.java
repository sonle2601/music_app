package com.example.musicapp.Service;

import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.Model.Banner;
import com.example.musicapp.Model.Taikhoan;
import com.example.musicapp.Model.Theloai;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("songbanner.php")
    Call<Banner> getBanner();

    @GET("bxh.php")
    Call<BXH> getBXH();

    @GET("theloai.php")
    Call<Theloai> getTheloai();


    @GET("album.php")
    Call<Album> getAlbum();

    @GET("like.php")
    Call<Baihatyeuthich> getLike();



    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<Baihatyeuthich> getDanhSachBaiHatTheoQuangCao(@Field("idbanner") int idbanner);

    @GET("dsbxh.php")
    Call<BXH> getAllBXH();

    @FormUrlEncoded
    @POST("dsbhbxh.php")
    Call<Baihatyeuthich> getDanhSachBaiHatTheoBXH(@Field("idbxh") int idbxh);

    @GET("alltheloai.php")
    Call<Theloai> getAllTheloai();
    @FormUrlEncoded
    @POST("dsbhtheloai.php")
    Call<Baihatyeuthich> getDanhSachBaiHatTheloai(@Field("idtheloai") int idtheloai);


    @GET("allalbum.php")
    Call<Album> getAllAlbum();

    @FormUrlEncoded
    @POST("dsbhalbum.php")
    Call<Baihatyeuthich> getDanhSachBaiHatAlbum(@Field("idalbum") int idalbum);

    @FormUrlEncoded
    @POST("updatelike.php")
    Call<String> UpdateLuotThich(@Field("luotthich") int luotthich,@Field("idbaihat") int idbaihat);

    @FormUrlEncoded
    @POST("search.php")
    Call<Baihatyeuthich> getSearchBaiHat(@Field("tukhoa") String tukhoa);

    @FormUrlEncoded
    @POST("taikhoan.php")
    Call<Taikhoan> checkTaikhoan(@Field("tendangnhap") String tendangnhap, @Field("matkhau") String matkhau);

}
