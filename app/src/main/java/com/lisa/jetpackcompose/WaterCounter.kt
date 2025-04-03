package com.lisa.jetpackcompose

import android.R.attr.checked
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        var count by remember { mutableStateOf(0) }
//        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
////                WellnessTaskItem(
////                    onClose = { showTask = false },
////                    taskName = "Have you taken your 15 minute walk today?"
////                )
//            }
//            Text("You've had $count glasses.")
//        }
//
//        Row(Modifier.padding(top = 8.dp)) {
//            Button(onClick = { count++ }, enabled = count < 10) {
//                Text("Add one")
//            }
//            Button(
//                onClick = { count = 0 },
//                Modifier.padding(start = 8.dp)) {
//                Text("Clear water count")
//            }
//        }
//    }
//}
//
//@Composable
//fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        if (count > 0) {
//            Text("You've had $count glasses.")
//        }
//        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
//            Text("Add one")
//        }
//    }
//}
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id },

        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
//@Composable
//fun StatefulCounter() {
//    var waterCount by remember { mutableStateOf(0) }
//
//    var juiceCount by remember { mutableStateOf(0) }
//
//    StatelessCounter(waterCount, { waterCount++ })
//    StatelessCounter(juiceCount, { juiceCount++ })
//}
