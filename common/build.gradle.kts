@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.ivos.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 27

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    //Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.hilt.navigation)

    //Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.json)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.resources)
    implementation(libs.ktor.client.okhttp)

    //Room
    implementation(libs.room)
    ksp(libs.room.compiler)

    implementation(libs.compose.foundation)
}
