package nl.jaysh.simplenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import nl.jaysh.designsystem.theme.SimpleNewsTheme
import nl.jaysh.overview.OverviewScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNewsTheme {
                OverviewScreen(viewModel = hiltViewModel())
            }
        }
    }
}
