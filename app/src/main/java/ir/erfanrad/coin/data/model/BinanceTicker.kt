package ir.erfanrad.coin.data.model

import ir.erfanrad.coin.domin.model.Coin
import kotlinx.serialization.Serializable



@Serializable
data class BinanceTicker(
    val s: String,  // Symbol (مثل "BTCUSDT")
    val c: String,  // آخرین قیمت (Close)
    val p: String,  // تغییر قیمت 24h
    val h: String   // بالاترین قیمت 24h
) {
    fun toDomain(): Coin {
        return Coin(
            id = s,
            symbol = s.replace("USDT", ""),
            price = c.toDoubleOrNull() ?: 0.0,
            change24h = p.toDoubleOrNull() ?: 0.0
        )
    }
}