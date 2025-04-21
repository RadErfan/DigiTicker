import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")

    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
}

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

android {
    namespace = "ir.erfanrad.coin"
    compileSdk = 35



    defaultConfig {
        applicationId = "ir.erfanrad.coin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )



        }
        
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ===== Ktor (Networking) =====
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization)  // برای JSON (مثل kotlinx.serialization)
    implementation(libs.ktor.client.logging)  // لاگ کردن درخواست‌ها

    // Room components
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)  // برای پشتیبانی از Coroutines
    kapt(libs.room.compiler)  // پردازش Annotationهای Room

    // ===== Kotlin Coroutines & Flow =====
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // Ktor Core
    implementation(libs.ktor.client.core)
    // موتور CIO (برای JVM/Android)
    implementation(libs.ktor.client.cio)
    // پلاگین ContentNegotiation برای JSON
    implementation(libs.ktor.client.content.negotiation)
    // سریالایزیشن JSON
    implementation(libs.ktor.serialization.kotlinx.json)
    // کتابخانه kotlinx.serialization
    implementation(libs.kotlinx.serialization.json)

    // برای Compose
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Hilt Core
    implementation("com.google.dagger:hilt-android:2.48.1") // نسخه آخر را بررسی کنید
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    // Hilt برای Compose (اگر از Jetpack Compose استفاده می‌کنید)
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")

}
