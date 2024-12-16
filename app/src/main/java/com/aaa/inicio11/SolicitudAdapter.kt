package com.aaa.inicio11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SolicitudAdapter(
    private val solicitudes: List<Solicitud>, // Lista de solicitudes a mostrar
    private val onAceptar: (Solicitud) -> Unit, // Acción al aceptar
    private val onRechazar: (Solicitud) -> Unit // Acción al rechazar
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {

    // ViewHolder para manejar cada item en el RecyclerView
    class SolicitudViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tipoTextView: TextView = view.findViewById(R.id.tipoPermiso) // Cambio al ID correcto
        val btnAceptar: ImageView = view.findViewById(R.id.btnAceptar)
        val btnRechazar: ImageView = view.findViewById(R.id.btnRechazar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudes[position]

        // Asignamos el tipo de permiso al TextView
        holder.tipoTextView.text = solicitud.tipo

        // Asignamos los listeners a los botones
        holder.btnAceptar.setOnClickListener { onAceptar(solicitud) }
        holder.btnRechazar.setOnClickListener { onRechazar(solicitud) }
    }

    override fun getItemCount(): Int = solicitudes.size
}











