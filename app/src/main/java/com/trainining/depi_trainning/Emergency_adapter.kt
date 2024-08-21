import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.trainining.depi_trainning.R

class EmergenyAdapter(val activity: Activity, val emergencies: ArrayList<Emergency>) :
    RecyclerView.Adapter<EmergenyAdapter.MVH>() {

    class MVH(view: View) : RecyclerView.ViewHolder(view) {
        val parent: CardView = view.findViewById(R.id.card)
        val iv: ImageView = view.findViewById(R.id.img)
        val tv: TextView = view.findViewById(R.id.tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergenyAdapter.MVH {
        val view = activity.layoutInflater.inflate(R.layout.emergency_list_item, parent, false)
        return MVH(view)
    }


    override fun onBindViewHolder(holder: EmergenyAdapter.MVH, position: Int) {
        holder.iv.setImageResource(emergencies[position].pic)
        holder.tv.text =emergencies[position].name
        holder.parent.setOnClickListener {
            val phoneNumber = "tel:${emergencies[position].number}"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = phoneNumber.toUri()
            }
            activity.startActivity(intent)
        }
    }


    override fun getItemCount() = emergencies.size
}
