package com.example.vmdemo.sesion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/** Todo lo que las pantallas necesitan saber del usuario que inició sesión. */
data class SesionUiState(
    val nombre: String = "",
    val rol: String = "",
    val estancia: String = ""
) {
    val esDireccion: Boolean get() = rol == "Dirección"
}

class SesionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SesionUiState())
    val uiState: StateFlow<SesionUiState> = _uiState.asStateFlow()

    fun iniciarSesion(nombre: String, rol: String, estancia: String) {
        _uiState.value = SesionUiState(nombre, rol, estancia)
    }

    fun cambiarEstancia(estancia: String) {
        _uiState.update { it.copy(estancia = estancia) }
    }

    fun cerrarSesion() {
        _uiState.value = SesionUiState()
    }
}
