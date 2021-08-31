package pt.pinho.caniscatalog.screens

sealed class UiState
{
    object Loading : UiState()
    object Loaded : UiState()
    object ErrorFetching : UiState()
    object NoData : UiState()
}
