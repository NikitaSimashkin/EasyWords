plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "ru.kram.easywords.translator"
	compileSdk = 33

	defaultConfig {
		minSdk = 24

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
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}

	kotlinOptions {
		jvmTarget = "11"
	}
}

dependencies {

	implementation(project(":common:base"))
	implementation("com.amazonaws:aws-android-sdk-translate:${Dependencies.translateAmazon}")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.coroutinesCore}")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Dependencies.coroutinesAndroid}")

	implementation("androidx.core:core-ktx:${Dependencies.androidCore}")
	implementation("androidx.appcompat:appcompat:${Dependencies.appCompat}")
	testImplementation("junit:junit:${Dependencies.junit}")
	androidTestImplementation("androidx.test.ext:junit:${Dependencies.androidJunit}")
}