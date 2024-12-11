package com.aaa.inicio11


import android.os.Parcel
import android.os.Parcelable

data class Solicitud(
    var tipo: String = "",
    var seccion: String = "",
    var horaSalida: String = "",
    var horaEntrada: String = "",
    var fecha: String = "",
    var destino: String = "",
    var autorizadores: List<String> = emptyList(),
    var estado: String = "pendiente" // Valor predeterminado
) : Parcelable {

    // Constructor para Parcel
    constructor(parcel: Parcel) : this(
        tipo = parcel.readString() ?: "",
        seccion = parcel.readString() ?: "",
        horaSalida = parcel.readString() ?: "",
        horaEntrada = parcel.readString() ?: "",
        fecha = parcel.readString() ?: "",
        destino = parcel.readString() ?: "",
        autorizadores = parcel.createStringArrayList() ?: emptyList(),
        estado = parcel.readString() ?: "pendiente"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipo)
        parcel.writeString(seccion)
        parcel.writeString(horaSalida)
        parcel.writeString(horaEntrada)
        parcel.writeString(fecha)
        parcel.writeString(destino)
        parcel.writeStringList(autorizadores)
        parcel.writeString(estado)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Solicitud> {
        override fun createFromParcel(parcel: Parcel): Solicitud {
            return Solicitud(parcel)
        }

        override fun newArray(size: Int): Array<Solicitud?> {
            return arrayOfNulls(size)
        }
    }
}





