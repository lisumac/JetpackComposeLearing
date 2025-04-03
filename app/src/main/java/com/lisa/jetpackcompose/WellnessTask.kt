package com.lisa.jetpackcompose

//data class WellnessTask(val id: Int, val label: String, var checked: Boolean = false)
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//data class WellnessTask(val id: Int, val label: String, val checked: MutableState<Boolean> = mutableStateOf(false))


class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}