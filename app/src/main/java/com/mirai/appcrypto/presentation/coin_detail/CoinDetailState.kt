package com.mirai.appcrypto.presentation.coin_detail

import com.mirai.appcrypto.domain.model.Coin
import com.mirai.appcrypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
