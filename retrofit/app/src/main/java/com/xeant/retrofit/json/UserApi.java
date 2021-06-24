package com.xeant.retrofit.json;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    String BASE_URL = "https://gjworks.me/";


    /**
     * GET 방식, URL/posts/{userId} 호출.
     * Data Type의 JSON을 통신을 통해 받음.
     * @Path("userId") String id : id 로 들어간 String 값을, 첫 줄에 말한
     * {userId}에 넘겨줌.
     * userId에 1이 들어가면
     * "http://jsonplaceholder.typicode.com/posts/1" 이 최종 호출 주소.
     * @param userId 요청에 필요한 userId
     * @return Data 객체를 JSON 형태로 반환.
     */


    @GET("login.php")
    Call<ResultModel> login(@Query("email") String email,
                                                      @Query("password") String password);

    @POST("login.php")
    Call<ResultModel> login_post(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @POST("index.php?")
    Call<ResultModel> get_config(
            @Query("module") String module,
            @Query("act") String act
    );


}
