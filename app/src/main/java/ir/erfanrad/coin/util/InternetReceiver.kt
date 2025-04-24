package ir.erfanrad.coin.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import ir.dunijet.dunibazaar.util.NetworkChecker

class InternetReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        context?.let {
            val cheker = NetworkChecker(it)
            if (cheker.isInternetConnected) {
            }else{
                Toast.makeText(it, "اینترنت متصل نیست", Toast.LENGTH_SHORT).show()
            }
        }

    }


}
