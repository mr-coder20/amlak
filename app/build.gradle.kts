plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
}

android {
    buildFeatures {

        viewBinding = true
    }
    namespace = "com.example.am_lakestan"
    compileSdk = 34

    defaultConfig {

        applicationId = "com.example.am_lakestan"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {
            isMinifyEnabled = true
            proguardFiles(

                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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

    implementation(libs.androidx.activity.activity.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.koin.core)
    implementation(libs.koin.test)
    implementation(libs.io.insert.koin.koin.android)
    implementation(libs.com.google.code.gson.gson)
    implementation(libs.retrofit)
    implementation(libs.adapter.rxjava2)
    implementation(libs.converter.gson)
    implementation(libs.rxandroid)
    implementation(libs.rxjava)
    implementation(libs.timber)
    implementation(libs.eventbus)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.viewpager2)
    implementation(libs.fresco)
    implementation(libs.com.tbuonomo.dotsindicator2)
    implementation(libs.androidx.dynamicanimation)
    implementation(libs.lottie)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.ismaeldivita.chip.navigation.bar)
    implementation (libs.dexter)


}