package com.example.tutorm7front

import retrofit2.http.GET

interface HeroService {
    @GET("heroes")
    suspend fun getHeroes(): HeroResponse
}
