package com.aaa.inicio11


data class Solicitud(
    val tipo: String = "",            // Tipo de permiso: Personal, Salud, etc.
    val seccion: String = "",         // Información adicional de sección.
    val destino: String = "",         // Destino relacionado al permiso.
    val horaSalida: String = "",      // Hora de salida.
    val horaEntrada: String = "",     // Hora de entrada.
    val autorizadores: List<String> = listOf(), // Lista de autorizadores.
    var estado: String = "pendiente"  // Estado: aceptado, rechazado, pendiente.
)







