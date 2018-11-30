import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.3.10"
val junit_jupiter_version = "5.3.2"
val assertk_version = "0.12"
val mockk_version = "1.8.13.kotlin13"

plugins {
    kotlin("jvm") version "1.3.10"
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junit_jupiter_version")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version")

    testCompile("com.willowtreeapps.assertk:assertk-jvm:$assertk_version")

    testCompile( "io.mockk:mockk:$mockk_version")

    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "4.8"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}