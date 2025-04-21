package ir.erfanrad.coin.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CoinInfo(
    val Name: String,
    val FullName: String
)