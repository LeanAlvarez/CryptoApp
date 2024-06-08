package com.mirai.appcrypto.domain.repository

import com.mirai.appcrypto.data.remote.dto.CoinDetailDto
import com.mirai.appcrypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto


}