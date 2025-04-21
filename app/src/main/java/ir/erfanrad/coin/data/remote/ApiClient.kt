package ir.erfanrad.coin.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import ir.erfanrad.coin.util.ApiEndpoints
import kotlinx.serialization.json.Json


object ApiClient {
    val client = HttpClient(CIO) {
        expectSuccess = true
        defaultRequest {
            url(ApiEndpoints.BASE_URL)

        }

        install(ContentNegotiation) {
            json(Json {
                isLenient= true
                prettyPrint= true  // tamame json  haro baraye ma khana kon
                explicitNulls = true
                coerceInputValues = true  // in emkan ro be ma mide ke default value be property ha set konim
                ignoreUnknownKeys = true }) // استفاده از kotlinx.serialization برای JSON
        }
    }

}

