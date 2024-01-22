import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.5.31"
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("io.cucumber:cucumber-java8:6.10.4")
    testImplementation("io.cucumber:cucumber-junit:6.10.4")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
        exceptionFormat = TestExceptionFormat.FULL
    }
    outputs.upToDateWhen { false }
    systemProperty("cucumber.publish.quiet", "true")
}

tasks.register("cucumber") {
    dependsOn("test")
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = sourceSets["test"].runtimeClasspath
            args = listOf("src/test/resources")
        }
    }
}