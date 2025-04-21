package ir.erfanrad.coin.presentation.main.state
sealed class UiEvent {
    data class ShowToast(val message: String) : UiEvent()
}
