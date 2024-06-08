package com.mirai.appcrypto.presentation.coin_list

import com.mirai.appcrypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
