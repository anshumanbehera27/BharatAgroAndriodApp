plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.anshuman.bharatagro"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anshuman.bharatagro"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Add the lotify libabry for the annimation
    implementation (libs.lottie)

    // add the  cricular view
    implementation (libs.material.v140)

    // add for the google Maps
    implementation (libs.play.services.location)


    // retrofit dependency
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation (libs.volley)

    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // add the Gemeni Dependency
    implementation("com.google.ai.client.generativeai:generativeai:0.7.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("org.json:json:20210307")


    // Kotlinx Coroutines Core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

// Kotlinx Coroutines Android
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Add The data for fir base
    implementation (platform("com.google.firebase:firebase-bom:33.1.1"))


   // Add The dependency for the convert the URL TO images
    implementation ("com.makeramen:roundedimageview:2.3.0")
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")

    // ADD google dependecy
    implementation ("com.google.android.gms:play-services-auth:20.5.0")
    











}