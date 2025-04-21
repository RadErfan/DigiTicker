package ir.erfanrad.coin.domin.repository

import ir.erfanrad.coin.data.model.CryptoResponse
import ir.erfanrad.coin.domin.model.Coin
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun observeTicker(symbols: List<String>): Flow<Coin>
}
