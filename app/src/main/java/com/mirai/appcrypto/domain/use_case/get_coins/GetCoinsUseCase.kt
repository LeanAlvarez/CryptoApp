package com.mirai.appcrypto.domain.use_case.get_coins

import com.mirai.appcrypto.common.Resource
import com.mirai.appcrypto.data.remote.dto.toCoin
import com.mirai.appcrypto.domain.model.Coin
import com.mirai.appcrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow  {
        try {

            emit(Resource.Loading<List<Coin>>())

            val coins = repository.getCoins().map { it.toCoin() }

            emit(Resource.Success<List<Coin>>(coins))

        }catch ( e: HttpException){

            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Un error inesperado ocurrio"))

        }catch (e: IOException){

            emit(Resource.Error<List<Coin>>("No se puede encontrar el servidor, revisa la conexion a internet"))

        }
    }
    }