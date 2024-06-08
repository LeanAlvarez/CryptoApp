package com.mirai.appcrypto.data.repository

import com.mirai.appcrypto.data.remote.CoinPaprikaApi
import com.mirai.appcrypto.data.remote.dto.CoinDetailDto
import com.mirai.appcrypto.data.remote.dto.CoinDto
import com.mirai.appcrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = api.getCoins()


    override suspend fun getCoinById(coinId: String): CoinDetailDto = api.getCoinById(coinId)



}

