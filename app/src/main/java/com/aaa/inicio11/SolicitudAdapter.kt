import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aaa.inicio11.R
import com.aaa.inicio11.Solicitud

class SolicitudAdapter(
    private val solicitudesList: List<Solicitud>,
    private val onAceptarClick: (Solicitud) -> Unit,
    private val onRechazarClick: (Solicitud) -> Unit
) : RecyclerView.Adapter<SolicitudAdapter.SolicitudViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolicitudViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solicitud, parent, false)
        return SolicitudViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder, position: Int) {
        val solicitud = solicitudesList[position]
        holder.bind(solicitud)
    }

    override fun getItemCount(): Int = solicitudesList.size

    inner class SolicitudViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tipoTextView: TextView = itemView.findViewById(R.id.tipoTextView)
        private val seccionTextView: TextView = itemView.findViewById(R.id.seccionTextView)
        private val aceptar: Button = itemView.findViewById(R.id.btnAceptar)
        private val rechazarButton: Button = itemView.findViewById(R.id.rechazarButton)

        fun bind(solicitud: Solicitud) {
            tipoTextView.text = solicitud.tipo
            seccionTextView.text = solicitud.seccion

            aceptarButton.setOnClickListener { onAceptarClick(solicitud) }
            rechazarButton.setOnClickListener { onRechazarClick(solicitud) }
        }
    }
}






