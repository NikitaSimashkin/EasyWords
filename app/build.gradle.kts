plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("kapt")
}

apply<ru.kram.easywords.dependencies.DaggerDependenciesPlugin>()
apply<ru.kram.easywords.dependencies.JetpackComposeDependenciesPlugin>()

android {
	namespace = "ru.kram.easywords"
	compileSdk = 34

	defaultConfig {
		applicationId = "ru.kram.easywords"
		minSdk = 24
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {

		debug {

		}

		release {
			isMinifyEnabled = true
			isShrinkResources = true
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				file("proguard-rules.pro")
			)
		}
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}

	buildFeatures {
		compose = true
	}

	composeOptions {
		kotlinCompilerExtensionVersion = Dependencies.compose
	}

	packagingOptions {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}

	kotlinOptions {
		jvmTarget = "11"
	}
}

dependencies {

	implementation(project(":translator"))
	with(Dependencies) {
		implementation("androidx.core:core-ktx:$androidCore")
		implementation("androidx.appcompat:appcompat:$appCompat")

		implementation("com.google.android.material:material:$material")
		implementation("androidx.constraintlayout:constraintlayout:$constraintLayout")

		// Junit
		testImplementation("junit:junit:$junit")
		androidTestImplementation("androidx.test.ext:junit:$androidJunit")

		// ViewModel
		implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModel")
		implementation("androidx.lifecycle:lifecycle-livedata-ktx:$viewModel")
		implementation("androidx.lifecycle:lifecycle-runtime-ktx:$viewModel")

		// Espresso
		androidTestImplementation("androidx.test.espresso:espresso-core:$espresso")

		// Coil
		implementation("io.coil-kt:coil-compose:$coil")
	}
}