package ir.erfanrad.coin

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.erfanrad.coin.data.model.Crypto
import ir.erfanrad.coin.presentation.ViewModel.CryptoViewModel
import ir.erfanrad.coin.presentation.main.state.CryptoIntent
import ir.erfanrad.coin.presentation.main.state.CryptoState
import ir.erfanrad.coin.presentation.main.state.UiEvent
import ir.erfanrad.coin.presentation.screen.CryptoPriceScreen
import ir.erfanrad.coin.ui.theme.CoinTheme
import ir.erfanrad.coin.util.InternetReceiver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var receiver:InternetReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        receiver = InternetReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver , filter)
        enableEdgeToEdge()
        setContent {
            CoinTheme {

                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    CryptoPriceScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoinTheme {

    }
}

