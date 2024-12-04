package com.aaa.inicio11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SolicitudAdapter(
    private val solicitudes: List<SolicitudPermiso>,
    private val onAceptarClick: (SolicitudPermiso) -> Unit,
    private val onRechazarClick: (SolicitudPermiso) -> Unit
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {

    inner class SolicitudViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tipoText: TextView = itemView.findViewById(R.id.tipoText)
        val aceptarButton: ImageView = itemView.findViewById(R.id.aceptIcon)
        val rechazarButton: ImageView = itemView.findViewById(R.id.cancelIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudes[position]
        holder.tipoText.text = solicitud.tipo
        holder.aceptarButton.setOnClickListener { onAceptarClick(solicitud) }
        holder.rechazarButton.setOnClickListener { onRechazarClick(solicitud) }
    }

    override fun getItemCount(): Int = solicitudes.size
}
