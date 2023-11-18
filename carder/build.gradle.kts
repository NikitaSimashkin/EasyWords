plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "ru.kram.easywords.carder"
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(project(":common:base"))
	implementation(project(":exampler"))
	implementation(project(":translator"))

	with(Dependencies) {
		implementation("androidx.core:core-ktx:$androidCore")
		implementation("androidx.appcompat:appcompat:$appCompat")
		testImplementation("junit:junit:$junit")
		androidTestImplementation("androidx.test.ext:junit:$androidJunit")

		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCore")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesAndroid")
	}
}