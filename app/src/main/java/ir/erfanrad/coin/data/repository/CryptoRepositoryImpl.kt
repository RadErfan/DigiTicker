// در فایل: `data/repository/CryptoRepositoryImpl.kt`
import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.HttpMethod
import io.ktor.websocket.*
import ir.erfanrad.coin.data.model.BinanceTicker
import ir.erfanrad.coin.domin.model.Coin
import ir.erfanrad.coin.domin.repository.CryptoRepository
import kotlinx.coroutines.flow.*
import kotlinx.serialization.json.Json
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val client: HttpClient
) : CryptoRepository {

    override fun observeTicker(symbols: List<String>): Flow<Coin> = flow {
        client.webSocket(method = HttpMethod.Get, host = "stream.binance.com") {
            // ساخت آدرس WebSocket (مثال: btcusdt@ticker/ethusdt@ticker)
            val streamName = symbols.joinToString("/") { "${it.lowercase()}@ticker" }
            send("/ws/$streamName")

            incoming.receiveAsFlow()
                .filterIsInstance<Frame.Text>()
                .mapNotNull { frame ->
                    try {
                        Json.decodeFromString<BinanceTicker>(frame.readText())
                    } catch (e: Exception) {
                        null // خطا در پارس کردن
                    }
                }
                .collect { ticker ->
                    emit(ticker.toDomain()) // تبدیل به مدل دامنه و انتشار
                }
        }
    }.catch { e ->
        // مدیریت خطا (مثلاً لاگ یا تلاش مجدد)
        println("WebSocket Error: ${e.message}")
    }
}