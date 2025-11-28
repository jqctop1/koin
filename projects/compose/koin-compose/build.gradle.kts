import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

val koinVersion: String by project
version = koinVersion

kotlin {
    jvmToolchain(17)
    /*jvm {
        withJava()
    }*/

    /*js(IR) {
        nodejs()
        browser()
        binaries.executable()
    }*/

    /*wasmJs {
        nodejs()
        binaries.executable()
    }*/

    iosX64()
    //iosArm64()
    //iosSimulatorArm64()
    //macosX64()
    //macosArm64()

    ohosArm64()

    sourceSets {
        commonMain.dependencies {
            api(project(":core:koin-core"))
            api(libs.jb.composeRuntime)
        }
    }
}

tasks.withType<KotlinCompile>().all {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

apply(from = file("../../gradle/publish.gradle.kts"))
