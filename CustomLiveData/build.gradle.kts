plugins {
    alias(libs.plugins.androidLibrary)
    id("com.vanniktech.maven.publish") version "0.28.0"
    id("signing")
}

android {
    namespace = "util.custom.livedata"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

mavenPublishing {
    coordinates("io.github.com", "custom-live-data", "1.0.0")

    pom {
        name.set("custom-live-data")
        description.set("LiveData's extended library")
        inceptionYear.set("2024")
        url.set("https://github.com/gemutsruhe/CustomLiveData")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://www.mit.edu/~amini/LICENSE.md")
                distribution.set("https://www.mit.edu/~amini/LICENSE.md")
            }
        }
        developers {
            developer {
                id.set("gemutsruhe")
                name.set("Hyesung O")
                url.set("https://github.com/gemutsruhe")
            }
        }
        scm {
            url.set("https://github.com/username/CustomLiveData/")
            connection.set("scm:git:git://github.com/gemutsruhe/CustomLiveData.git")
            developerConnection.set("scm:git:ssh://git@github.com/gemutsruhe/CustomLiveData.git")
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}