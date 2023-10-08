@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.ivos.domain"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":common"))

    implementation(libs.core.ktx)

    //Arrow
    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    //Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.hilt.navigation)

    //Test
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.mockk.android)
    testImplementation(libs.junit)
    testImplementation(libs.kotest.assertions)
    testImplementation(libs.kotest.assertions.arrow)
    testImplementation(libs.kotlinx.coroutines.test)
}
