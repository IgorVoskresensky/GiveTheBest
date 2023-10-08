@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.ivos.givethebest"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.ivos.givethebest"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    //Compose UI
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.lottie)

    //Test
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    //Arrow
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    //Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.json)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.resources)
    implementation(libs.ktor.client.okhttp)

    //Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.hilt.navigation) //delete

    //Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    //Coil
    implementation(libs.coil)
    implementation(libs.coil.svg)
    implementation(libs.coil.compose)

    //Input Masks
    implementation(libs.decoro)
    implementation(libs.input.mask.android)

    //Viewmodel Ktx
    implementation(libs.viewmodel.ktx)

    //CacheFixGradlePlugin
    implementation(libs.gradle.android.cacheFixGradlePlugin)

    //Room
    implementation(libs.room)
    ksp(libs.room.compiler)
}
