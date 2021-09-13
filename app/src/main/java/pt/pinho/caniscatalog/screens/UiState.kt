package pt.pinho.caniscatalog.screens

sealed class UiState {
    object Initial : UiState()
    object Loading : UiState()
    object Loaded : UiState()
    object LoadingError : UiState()
    object NoData : UiState()
}
