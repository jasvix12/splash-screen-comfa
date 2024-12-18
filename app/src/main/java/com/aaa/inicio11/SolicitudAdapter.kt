package com.aaa.inicio11

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class SolicitudAdapter(
    private val solicitudes: MutableList<Solicitud>,
    private val onAceptar: OnAceptarListener,
    private val onCancelar: OnCancelarListener
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {


    interface OnAceptarListener {
        fun onAceptar(solicitud: Solicitud?)
    }

    interface OnCancelarListener {
        fun onCancelar(solicitud: Solicitud?)
    }


    class SolicitudViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tipoTextView: TextView = view.findViewById(R.id.tipoPermiso)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudes[position]
        holder.tipoTextView.text = solicitud.tipo
        holder.itemView.setOnClickListener { v: View -> mostrarDialogo(v, solicitud) }
    }

    override fun getItemCount(): Int {
        return solicitudes.size
    }

    // Método para mostrar el diálogo
    private fun mostrarDialogo(view: View, solicitud: Solicitud) {
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Solicitud de Permiso")
        builder.setMessage("¿Deseas aceptar o cancelar el permiso de tipo \"" + solicitud.tipo + "\"?")

        builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
            Toast.makeText(view.context, "Permiso aceptado", Toast.LENGTH_SHORT).show()
            onAceptar.onAceptar(solicitud)
            dialog.dismiss()
        }

        builder.setNeutralButton("Cancelar") { dialog: DialogInterface, _ ->

            solicitudes.remove(solicitud)
            notifyDataSetChanged()
            Toast.makeText(view.context, "Acción cancelada", Toast.LENGTH_SHORT).show()
            onCancelar.onCancelar(solicitud)
            dialog.dismiss()
        }


        builder.create().show()
    }
}
















