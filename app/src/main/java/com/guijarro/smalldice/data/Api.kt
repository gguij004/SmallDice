package com.guijarro.smalldice.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Rest API: consume random number end point
 */

interface RandomNumberApi {

    @GET("integers/")
    suspend fun getRandomNumber(

        @Query("num") numbers: String = NUM,
        @Query("min") min: String = MIN,
        @Query("max") max: String = MAX,
        @Query("col") col: String = COL,
        @Query("base") base: String = BASE,
        @Query("format") format: String = FORMAT,
        @Query("rnd") rnd: String = RND,

        ): Response<String>

    companion object {
        const val BASE_URL = "https://www.random.org/"
        const val END_POINT = "/"
        const val NUM = "1"
        const val MIN = "1"
        const val MAX = "6"
        const val COL = "1"
        const val BASE = "10"
        const val FORMAT = "plain"
        const val RND = "new"
    }
}

//https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new
