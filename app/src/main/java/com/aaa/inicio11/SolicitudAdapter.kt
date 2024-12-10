package com.aaa.inicio11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SolicitudAdapter(
    private val solicitudes: MutableList<Solicitud>,
    private val onAceptarClick: (Solicitud) -> Unit,
    private val onRechazarClick: (Solicitud) -> Unit
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudes[position]


        holder.tvPermisoMensaje.text = solicitud.tipo

        holder.btnAceptar.setOnClickListener {
            onAceptarClick(solicitud)
        }

        holder.btnRechazar.setOnClickListener {
            onRechazarClick(solicitud)
        }
    }
    override fun getItemCount(): Int = solicitudes.size


    inner class SolicitudViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPermisoMensaje: TextView = itemView.findViewById(R.id.tvPermisoMensaje)
        val btnAceptar: ImageView = itemView.findViewById(R.id.btnAceptar)
        val btnRechazar: ImageView = itemView.findViewById(R.id.btnRechazar)
    }
}



