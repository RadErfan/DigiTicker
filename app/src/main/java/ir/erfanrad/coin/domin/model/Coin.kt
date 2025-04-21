package ir.erfanrad.coin.domin.model

data class Coin(
    val id: String,
    val symbol: String,
    val price: Double,
    val change24h: Double
)