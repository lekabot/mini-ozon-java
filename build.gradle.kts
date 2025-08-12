plugins {
  id("com.diffplug.spotless") version "6.25.0"
}

allprojects {
  repositories { mavenCentral() }
}

subprojects {
  apply(plugin = "java")

  tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "21"
    targetCompatibility = "21"
    options.encoding = "UTF-8"
  }

  tasks.withType<Test>().configureEach {
    useJUnitPlatform()
  }
}

tasks.register("runUsers") { dependsOn(":services:users-service:bootRun") }
tasks.register("runCatalog") { dependsOn(":services:catalog-service:bootRun") }
