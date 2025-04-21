package ir.erfanrad.coin.util

object ApiEndpoints {
    // Base URL
    const val BASE_URL = "https://min-api.cryptocompare.com"
    const val GET_CRYPTO_PRICE = "$BASE_URL/data/price?fsym={FROM}&tsyms={TO}"

    // REST Endpoints
    const val GET_CRYPTO_LIST = "$BASE_URL/assets"

    // WebSocket Endpoints
    const val WS_BASE_URL = "wss://ws.coincap.io"
    const val WS_CRYPTO_PRICES = "$WS_BASE_URL/prices?assets="
}