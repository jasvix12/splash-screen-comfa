package com.aaa.inicio11

import com.aaa.inicio11.FakeDatabase.solicitudes


object FakeDatabase {
    val solicitudes = mutableListOf(
        SolicitudPermiso("Laboral", "Recursos Humanos", "8:00 AM", "12:00 PM"),
        SolicitudPermiso("Personal", "Administración", "10:00 AM", "2:00 PM")
    )
}

    // Función para agregar solicitudes
    fun addSolicitud(solicitud: SolicitudPermiso) {
        solicitudes.add(solicitud)
    }

    fun aceptarSolicitud(solicitud: SolicitudPermiso) {
        solicitudes.remove(solicitud)

    }

    fun rechazarSolicitud(solicitud: SolicitudPermiso) {
        solicitudes.remove(solicitud)
    }

        fun obtenerTodasLasSolicitudes(): List<SolicitudPermiso> {
            return solicitudes
        }




