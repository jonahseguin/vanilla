import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.71"
    id("com.github.johnrengelman.shadow") version "5.0.0"
    maven
}

group = "com.jonahseguin"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
    maven(url = "https://jcenter.bintray.com")

    maven(url = "https://kotlin.bintray.com/kotlinx")

    maven(url = "https://repo.maven.apache.org/maven2")
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    val koinVersion = "2.1.4"

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.spigotmc:spigot-api:1.15.2-R0.1-SNAPSHOT")
    implementation("org.koin:koin-core:$koinVersion")
    implementation("org.litote.kmongo:kmongo-id-jackson:3.12.0")
    implementation("org.litote.kmongo:kmongo:3.12.0")

    testImplementation("org.koin:koin-test:$koinVersion")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    archiveFileName.set("vanilla.jar")
}