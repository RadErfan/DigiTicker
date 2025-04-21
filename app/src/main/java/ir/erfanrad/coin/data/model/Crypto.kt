package ir.erfanrad.coin.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Crypto(
    val id: String,
    val rank: String,
    val symbol: String,
    val name: String,
    val supply: String,
    val priceUsd: String,
    val changePercent24Hr: String
)
