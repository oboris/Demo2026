package ua.edu.cdu.boris.demo2026.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import ua.edu.cdu.boris.demo2026.R

@Composable
fun DeleteButton(onDelBtnClick: () -> Unit) {
    Button(
        onClick = onDelBtnClick,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
    ) {
        Icon(
            painterResource(R.drawable.outline_delete_24),
            contentDescription = "Delete Button"
        )
    }
}