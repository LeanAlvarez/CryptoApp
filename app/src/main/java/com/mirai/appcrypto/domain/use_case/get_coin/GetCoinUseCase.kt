package com.mirai.appcrypto.domain.use_case.get_coin

import com.mirai.appcrypto.common.Resource
import com.mirai.appcrypto.data.remote.dto.toCoin
import com.mirai.appcrypto.data.remote.dto.toCoinDetail
import com.mirai.appcrypto.domain.model.Coin
import com.mirai.appcrypto.domain.model.CoinDetail
import com.mirai.appcrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow  {
        try {

            emit(Resource.Loading<CoinDetail>())

            val coin = repository.getCoinById(coinId).toCoinDetail()

            emit(Resource.Success<CoinDetail>(coin))

        }catch ( e: HttpException){

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Un error inesperado ocurrio"))

        }catch (e: IOException){

            emit(Resource.Error<CoinDetail>("No se puede encontrar el servidor, revisa la conexion a internet"))

        }
    }
    }