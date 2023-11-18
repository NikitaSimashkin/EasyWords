plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "ru.kram.easywords.exampler"
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
	with(Dependencies) {
		implementation("io.ktor:ktor-client-core:$ktor")
		implementation("io.ktor:ktor-client-cio:$ktor")

		implementation("org.jsoup:jsoup:$jsoup")

		implementation("androidx.core:core-ktx:$androidCore")
		implementation("androidx.appcompat:appcompat:$appCompat")
		testImplementation("junit:junit:$junit")
		androidTestImplementation("androidx.test.ext:junit:$androidJunit")
	}
}