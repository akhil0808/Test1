package com.example.test.retrofit

import com.example.test.ui.models.UserDetailsResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {

    // https://gorest.co.in/public-api/users
    @GET("public-api/users")
    fun getUserMaster(): Observable<UserDetailsResponse>

}
