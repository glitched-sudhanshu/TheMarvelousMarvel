package com.example.tmm.data.repository

import com.example.tmm.data.data_source.MarvelApi
import com.example.tmm.data.data_source.dto.*
import com.example.tmm.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api : MarvelApi
) : MarvelRepository {
    override suspend fun getAllCharacter(offset: Int): CharactersDTO {
        return api.getAllCharacters(offset = offset.toString())
    }

    override suspend fun getAllSearchCharacter(search: String): CharactersDTO {
        return api.getAllSearchCharacters(search = search)
    }

    override suspend fun getAllCreator(offset: Int): CreatorsDTO {
        return api.getAllCreators(offset = offset.toString())
    }

    override suspend fun getAllSearchCreator(search: String): CreatorsDTO {
        return api.getAllSearchCreators(search = search)
    }

    override suspend fun getAllComics(offset: Int): ComicsDTO {
        return api.getAllComics(offset = offset.toString())
    }

    override suspend fun getAllSearchComics(search: String): ComicsDTO {
        return api.getAllSearchComic(search = search)
    }

    override suspend fun getAllEvents(offset: Int): EventsDTO {
        return api.getAllEvents(offset = offset.toString())
    }

    override suspend fun getAllSearchEvents(search: String): EventsDTO {
        return api.getAllSearchEvents(search = search)
    }

    override suspend fun getAllSeries(offset: Int): SeriesDTO {
        return api.getAllSeries(offset = offset.toString())
    }

    override suspend fun getAllSearchSeries(search: String): SeriesDTO {
        return api.getAllSearchSeries(search = search)
    }
}