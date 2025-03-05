package com.example.tutorm7front

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface HeroService {
    @GET("heroes")
    suspend fun getHeroes(): HeroResponse

    @PUT("heroes/update/{id}")
    suspend fun updateHero(@Path("id") id: String, @Body hero: HeroEntity)

    @DELETE("heroes/{id}")
    suspend fun deleteHero(@Path("id") id: String)

}
