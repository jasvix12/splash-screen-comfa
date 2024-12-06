package com.aaa.inicio11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SolicitudAdapter(
    private val solicitudes: MutableList<SolicitudPermiso>,
    private val onAceptarClick: (SolicitudPermiso) -> Unit,
    private val onRechazarClick: (SolicitudPermiso) -> Unit
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudes[position]
        holder.bind(solicitud)
    }

    override fun getItemCount(): Int = solicitudes.size

    inner class SolicitudViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSolicitudMensaje: TextView = itemView.findViewById(R.id.tvSolicitudMensaje)
        private val btnAceptar: ImageView = itemView.findViewById(R.id.btnAceptar)
        private val btnRechazar: ImageView = itemView.findViewById(R.id.btnRechazar)

        fun bind(solicitud: SolicitudPermiso) {
            tvSolicitudMensaje.text = "${solicitud.tipo} - ${solicitud.seccion}"

            btnAceptar.setOnClickListener {
                onAceptarClick(solicitud)
            }

            btnRechazar.setOnClickListener {
                onRechazarClick(solicitud)
            }
        }
    }
}


