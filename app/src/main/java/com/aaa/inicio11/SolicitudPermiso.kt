package com.aaa.inicio11

import android.os.Parcel
import android.os.Parcelable

data class Solicitud(
    val tipo: String,
    val seccion: String,
    val horaSalida: String,
    val horaEntrada: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        tipo = parcel.readString() ?: "",
        seccion = parcel.readString() ?: "",
        horaSalida = parcel.readString() ?: "",
        horaEntrada = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipo)
        parcel.writeString(seccion)
        parcel.writeString(horaSalida)
        parcel.writeString(horaEntrada)
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




