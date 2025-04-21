package ir.erfanrad.coin.di

import CryptoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import ir.erfanrad.coin.data.remote.ApiClient
import ir.erfanrad.coin.domin.repository.CryptoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient():HttpClient{
        return HttpClient(CIO){
            install(WebSockets)
        }
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(client: HttpClient): CryptoRepository{
        return CryptoRepositoryImpl(client)
    }
}
