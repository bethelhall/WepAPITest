package com.example.webapitest.services

import com.example.webapitest.Bid
import com.example.webapitest.User
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface BidService {
    @GET("bids")
    fun getBids(): Call<List<Bid>>

    @GET("bid/{id}")
    fun getBid(@Path("id") id: Int): Call<Bid>

    @POST("bid")
    fun postBid(@Body newBid: Bid): Call<Bid>

    @FormUrlEncoded
    @PUT("bid/{id}")
    fun updateBid(
        @Path("id") id: Int,
        @Field("bid_amount") bid_amount: Long,
        @Field("bid_date") bid_date: Date
    )

    @DELETE("bid/{id}")
    fun deleteBid(@Path("id") id: Int): Call<Void>
}