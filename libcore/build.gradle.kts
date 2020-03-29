plugins {
    id("com.android.library")
    kotlin("android")//或者 id("kotlin-android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildTools)

    defaultConfig {
        minSdkVersion(minSdk)
        targetSdkVersion(targetSdk)
        versionCode = libCode
        versionName = libVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib", kotlin_version))
//    implementation(DepLibrary.APPCOMPAT)
//    implementation(DepLibrary.CORE_KTX)
//    implementation(DepLibrary.COROUTINES_ANDROID)

    //test dependencies
    addTestDependencies()

}