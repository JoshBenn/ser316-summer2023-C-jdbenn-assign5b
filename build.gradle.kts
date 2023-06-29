plugins {
    id("java")
    id("com.github.spotbugs") version("4.5.1")
    id("checkstyle")
}

//spotbugsMain {
//    reports {
//        xml.enabled = false
//        html.enabled = true
//    }
//}
//
//spotbugsTest {
//    reports {
//        xml.enabled = false
//        html.enabled = true
//    }
//}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.h3xstream.findsecbugs:findsecbugs-plugin:1.12.0")
}

tasks.test {
    useJUnitPlatform()
}