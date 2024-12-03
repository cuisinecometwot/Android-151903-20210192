package com.example.studentmanagerfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentmanagerfragment.models.StudentModel

class StudentViewModel : ViewModel() {
    val students = MutableLiveData<MutableList<StudentModel>>()

    init {
        students.value = mutableListOf(
            StudentModel("Student A", "SV001"),
            StudentModel("Student B", "SV002"),
            StudentModel("Student C", "SV003"),
            StudentModel("Nguyen Huu Duc", "20210192"),
        )
    }

    fun saveStudent(student: StudentModel, position: Int?) {
        val currentList = students.value ?: mutableListOf()
        if (position != null && position >= 0) {
            currentList[position] = student
        } else {
            currentList.add(student)
        }
        students.value = currentList
    }
}