package com.example.myapplication.presentation

import android.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.domain.Variet
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val open by viewModel.open.collectAsStateWithLifecycle()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Menu(viewModel)
        if (open){
            OpenDialog(funcAdd = viewModel::add, onDismiss = {viewModel.open()})
        }
        Spacer(modifier = Modifier.weight(1f))
        AddButton({ viewModel.open() })
    }
}

@Composable
fun Menu(viewModel: MainScreenViewModel) {
    val varieties by viewModel.varieties.collectAsStateWithLifecycle()
    val isOpen by viewModel.openOptions.collectAsStateWithLifecycle()

    Box() {
        IconButton(onClick = { viewModel.openOptions() }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Показать меню")
        }
        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = { viewModel.openOptions() }
        ) {
            for (variety in varieties) {
                Text(text = variety.description, modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
fun AddButton(funcOpen: () -> Unit) {
    Button(onClick = { funcOpen() }, modifier = Modifier.fillMaxWidth()) {
        Text("Добавить опцию")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenDialog(funcAdd: (String) -> Unit, onDismiss: () -> Unit) {
    var newOption by remember { mutableStateOf("") }
    val title = rememberSaveable { mutableStateOf("Новая опция") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {funcAdd(newOption)} ) {
                Text("Добавить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        },
        shape = RoundedCornerShape(16),
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ){
                OutlinedTextField(
                    value = newOption,
                    onValueChange = {newOption = it},
                    label = {Text("Новая опция")},
                    shape = RoundedCornerShape(16)
                )
            }
        }
    )
}