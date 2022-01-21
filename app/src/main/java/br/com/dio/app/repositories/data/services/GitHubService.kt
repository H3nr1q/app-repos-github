package br.com.dio.app.repositories.data.services

import br.com.dio.app.repositories.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{users}/repos")
    suspend fun listRepositories(@Path("users")user: String): List<Repo>

}