package br.com.dio.app.repositories.repositories


import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.model.Repo
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoriesImpl(private val service: GitHubService): RepoRepository {
    override suspend fun listRepositories(user: String) = flow<List<Repo>> {
       try {
           val repoList = service.listRepositories(user)
           emit(repoList)
       }catch (ex: HttpException){
           throw RemoteException(ex.message?: "Não foi possível fazer a busca no momento")
       }

    }


}