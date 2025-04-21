package ir.erfanrad.coin.presentation.main.state

sealed class CryptoIntent {
    object LoadCryptoList : CryptoIntent()
    data class SubscribeToPrices(val ids: List<String>) : CryptoIntent()
}
