package com.lisa.jetpackcompose



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Step 1: Data class for User
data class User(val id: Int, val name: String, val age: Int)

// Step 2: Extension function to generate sample users
fun generateUsers(count: Int) = List(count) { index ->
    User(id = index + 1, name = "User ${index + 1}", age = (18..40).random())
}

// Step 3: Composable function to display User List
@Composable
fun UserList(users: List<User>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(users) { user ->
            UserCard(user)
        }
    }
}

// Step 4: Composable function for individual User Card (with scope functions)
@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            with(user) { // Using 'with' to avoid repeated 'user.'
                Text(text = "ID: $id", style = MaterialTheme.typography.titleMedium)
                Text(text = "Name: $name", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Age: $age years", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

// Step 5: Main Screen - Calls the UserList function
@Composable
fun MainScreen() {
    val users = remember { generateUsers(10) } // Using 'remember' for state retention

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "User List", style = MaterialTheme.typography.headlineMedium)
        UserList(users)
    }
}

// Step 6: Set the content in MainActivity
class ScopeFunctionExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

// Step 7: Preview Function
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
