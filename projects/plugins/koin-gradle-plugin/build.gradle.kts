import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    groovy
}

dependencies {
    //implementation(project(":core:koin-test"))
    implementation(gradleApi())
}

tasks.withType<KotlinCompile>().all {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
java {
    sourceCompatibility = JavaVersion.VERSION_11 // or the desired Java version
    targetCompatibility = JavaVersion.VERSION_17 // or the desired Java version
}
val sourcesJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.map { it.allSource.sourceDirectories })
}

apply(from = file("../../gradle/publish-java.gradle.kts"))
