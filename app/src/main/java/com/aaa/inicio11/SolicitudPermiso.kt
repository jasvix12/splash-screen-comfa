package com.aaa.inicio11

import android.os.Parcel
import android.os.Parcelable

data class SolicitudPermiso(
    val tipo: String,
    val seccion: String,
    val horaSalida: String,
    val horaEntrada: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipo)
        parcel.writeString(seccion)
        parcel.writeString(horaSalida)
        parcel.writeString(horaEntrada)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<SolicitudPermiso> {
        override fun createFromParcel(parcel: Parcel): SolicitudPermiso = SolicitudPermiso(parcel)
        override fun newArray(size: Int): Array<SolicitudPermiso?> = arrayOfNulls(size)
    }
}

