package ir.erfanrad.coin.presentation.main.state

import ir.erfanrad.coin.data.model.Crypto

data class CryptoState(
    val isLoading: Boolean = false,
    val cryptoList: List<Crypto> = emptyList(),
    val prices: Map<String, String> = emptyMap(),
    val error: String? = null
)
