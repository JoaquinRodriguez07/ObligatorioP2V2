plugins {
    id("java")
}

group = "um.edu.uy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    //lombok
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")

    //open csv
    implementation("com.opencsv:opencsv:3.7")
    testImplementation("com.opencsv:opencsv:3.7")
    compileOnly("com.opencsv:opencsv:3.7")
    runtimeOnly("com.opencsv:opencsv:3.7")
}

tasks.test {
    useJUnitPlatform()
}