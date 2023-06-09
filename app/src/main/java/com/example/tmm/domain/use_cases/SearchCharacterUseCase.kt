package com.example.tmm.domain.use_cases

import com.example.tmm.domain.model.Character
import com.example.tmm.domain.repository.MarvelRepository
import com.example.tmm.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class SearchCharacterUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(search : String) : Flow<Response<List<Character>>> = flow {
        try{
            emit(Response.Loading<List<Character>>())
            val list = repository.getAllSearchCharacter(search = search).data.results.map {
                it.toCharacter()
            }
            emit(Response.Success<List<Character>>(list))
        }
        catch (e : HttpException){
            emit(Response.Error<List<Character>>(e.printStackTrace().toString()))
        }
        catch (e : IOException)
        {
            emit(Response.Error<List<Character>>(e.printStackTrace().toString()))
        }
    }
}