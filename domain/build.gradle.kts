plugins {
    id("java-library")
    id("kotlin-kapt")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.ksp)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.core)
    kapt(libs.hilt.android.compiler)
}