plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "edu.qc.seclass.rlm"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.qc.seclass.rlm"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.car.ui:car-ui-lib:2.5.1")
    implementation("com.google.firebase:firebase-auth:22.2.0")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("androidx.media3:media3-common:1.2.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    //androidTestImplementation("com.adevinta.android:barista:4.2.0")
    androidTestImplementation ("com.schibsted.spain:barista:4.1.0")

}

//    def room_version = "2.4.2"
//    implementation "andriodx.room:room-runtime:$room_version"
//    annotationProcessor "androidx.room:room-compiler:$room_version"
//repositories{
//    google()
//}