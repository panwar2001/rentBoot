plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `kotlin-dsl`
}
group = "com.panwar2001.rentboot.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
}


gradlePlugin {
    val androidApplicationCompose="AndroidApplicationComposeConventionPlugin"
    val androidApplicationComposeId= "convention.android.application.compose"

    val androidLibraryCompose= "AndroidLibraryComposeConventionPlugin"
    val androidLibraryComposeId= "convention.android.library.compose"

    val androidLibrary = "AndroidLibraryConventionPlugin"
    val androidLibraryId = "convention.android.library"

    val androidHilt = "HiltConventionPlugin"
    val androidHiltId = "convention.hilt"

    val androidFeature = "AndroidFeatureConventionPlugin"
    val androidFeatureId = "convention.android.feature"

    val androidRoom = "AndroidRoomConventionPlugin"
    val androidRoomId= "convention.android.room"

    val androidTest = "AndroidTestConventionPlugin"
    val androidTestId = "convention.android.test"


    plugins {
        /**
         * Register Compose application and library plugin.
         */
        register(androidApplicationCompose) {
            id = androidApplicationComposeId
            implementationClass = androidApplicationCompose
        }
        register(androidLibraryCompose) {
            id = androidLibraryComposeId
            implementationClass = androidLibraryCompose
        }
        /**
         * Register Android application and library plugin.
         */
        register("AndroidApplicationConventionPlugin") {
            id = "convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register(androidLibrary) {
            id = androidLibraryId
            implementationClass = androidLibrary
        }
        /**
         * Register plugin for features which are build with compose
         */
        register(androidFeature) {
            id = androidFeatureId
            implementationClass = androidFeature
        }
        /**
         * Register hilt plugin
         */
        register(androidHilt) {
            id = androidHiltId
            implementationClass = androidHilt
        }
        /**
         * Register room plugin
         */
        register(androidRoom) {
            id = androidRoomId
            implementationClass = androidRoom
        }
        /**
         * Register test plugin
         */
        register(androidTest) {
            id = androidTestId
            implementationClass = androidTest
        }

    }
}
