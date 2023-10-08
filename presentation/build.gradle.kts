@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.ivos.presentation"
    compileSdk = 34

    defaultConfig {
        namespace = "ru.ivos.presentation"
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
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
        compose = true
    }

}

dependencies {


    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":domain")))

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.mockk)

    //Compose UI
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.material3)
    implementation(libs.compose.material2)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.compose.lottie)
    implementation(libs.compose.navigation)
    implementation(libs.compose.foundation)

    //Splash
    implementation(libs.splash.screen)

    //Viewmodel
    implementation(libs.core.ktx)
    implementation(libs.viewmodel.ktx)

    //Arrow
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    //Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.hilt.navigation)
}
