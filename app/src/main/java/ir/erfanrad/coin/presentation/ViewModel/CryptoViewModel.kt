package ir.erfanrad.coin.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.erfanrad.coin.domin.model.Coin
import ir.erfanrad.coin.domin.repository.CryptoRepository
import ir.erfanrad.coin.presentation.ViewModel.CryptoViewModel.UiState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val repository: CryptoRepository
):ViewModel() {

    private val _state = MutableStateFlow<UiState>(Loading)
    val state: StateFlow<UiState> = _state

    init {
        observeTickers()
    }

    private fun observeTickers() {
        repository.observeTicker(listOf("BTCUSDT", "ETHUSDT"))
            .onEach { coin ->
                _state.update { currentState ->
                    when (currentState) {
                        is Success -> currentState.copy(coins = currentState.coins + coin)
                        else -> Success(listOf(coin))
                    }
                }
            }
            .launchIn(viewModelScope)
    }


    sealed class UiState {
        data object Loading : UiState()
        data class Success(val coins: List<Coin>) : UiState()
        data class Error(val message: String) : UiState()
    }
}

