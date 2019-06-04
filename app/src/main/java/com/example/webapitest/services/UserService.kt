package com.example.webapitest.services

import com.example.webapitest.User
import retrofit2.Call
import retrofit2.http.*


interface UserService {

    @GET("user")
    fun getUsers(): Call<List<User>>

    @GET("user/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @POST("user")
    fun createUser(@Body newUser: User): Call<User>

    @FormUrlEncoded
    @PUT("user/{id}")
    fun updateUser(
        @Path("id") id: Int,
        @Field("user_name") user_name: String,
        @Field("password") password: Int,
        @Field("address") address: String

    ): Call<User>

    @DELETE("user/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>


}