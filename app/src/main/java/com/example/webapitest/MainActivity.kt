package com.example.webapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.webapitest.services.ServiceBuilder
import com.example.webapitest.services.UserService
import kotlinx.android.synthetic.main.activity_main.*

import com.example.webapitest.services.BidService
import com.example.webapitest.services.ItemService

class MainActivity : AppCompatActivity() {
    private lateinit var userName: TextView
    private lateinit var bidView: TextView
    private lateinit var itemView: TextView

    private lateinit var userService: UserService
    private lateinit var bidService: BidService
    private lateinit var itemService: ItemService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = user_view
        bidView = bids_view2
        itemView = item_view

        userService = ServiceBuilder.buildService(userService::class.java)
        bidService = ServiceBuilder.buildService(bidService::class.java)
        itemService = ServiceBuilder.buildService(itemService::class.java)

        val request2 = bidService.getBid(1)
        val request = userService.getUser(1)
        val request3 = itemService.getItem(2)


        val response = request.execute().body()
        val response2 = request2.execute().body()
        val response3 = request3.execute().body()

        userName.setText(response?.user_name.toString())
        bidView.setText(response2?.bid_amount.toString())
        itemView.setText(response3?.item_name)


    }


}


