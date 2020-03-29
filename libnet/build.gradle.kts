plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
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
    implementation(DepLibrary.COROUTINES_ANDROID)
    implementation(DepLibrary.LIFECYCLE_LIVEDATA)
    implementation(DepLibrary.LIFECYCLE_LIVEDATA_KTX)

    //retrofit okhttp gson
    implementation(DepLibrary.RETROFIT)
    implementation(DepLibrary.RETROFIT_CONVERTER_GSON)

    implementation(DepLibrary.OKHTTP)
    implementation(DepLibrary.MOCK_OKHTTP)

    implementation(DepLibrary.GSON)

    //依赖core
    api(project(":libcore"))

    //test
    addTestDependencies()
}