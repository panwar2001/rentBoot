import com.android.build.api.dsl.LibraryExtension
import com.panwar2001.convention.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    private val androidLibraryPluginId = "com.android.library"
    private val kotlinAndroidPluginId = "org.jetbrains.kotlin.android"
    private val testInstrumentationRunner= "androidx.test.runner.AndroidJUnitRunner"
    private val androidTestImplementation= "androidTestImplementation"
    private val testImplementation= "testImplementation"
    private val test="test"
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(androidLibraryPluginId)
                apply(kotlinAndroidPluginId)
            }
            extensions.configure<LibraryExtension> {
                configureAndroid(this)
                testOptions.animationsDisabled = true
                defaultConfig.testInstrumentationRunner = testInstrumentationRunner
                dependencies {
                    add(androidTestImplementation, kotlin(test))
                    add(testImplementation, kotlin(test))
                }
            }
        }
    }
}
