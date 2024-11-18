package vn.edu.hust.studentman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
  private val students: MutableList<StudentModel>,
  private val onEdit: (StudentModel, Int) -> Unit,
  private val onDelete: (StudentModel, Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

  inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.text_student_name)
    val idTextView: TextView = itemView.findViewById(R.id.text_student_id)
    val editImageView: ImageView = itemView.findViewById(R.id.image_edit)
    val deleteImageView: ImageView = itemView.findViewById(R.id.image_remove)

    init {
      editImageView.setOnClickListener {
        onEdit(students[adapterPosition], adapterPosition)
      }
      deleteImageView.setOnClickListener {
        onDelete(students[adapterPosition], adapterPosition)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
    return StudentViewHolder(view)
  }

  override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
    val student = students[position]
    holder.nameTextView.text = student.studentName
    holder.idTextView.text = student.studentId
  }

  override fun getItemCount(): Int = students.size
}