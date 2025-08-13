plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dep.mgmt)
}

dependencies {
    implementation(project(":libs:common"))
    implementation(libs.boot.web)
    implementation(libs.boot.data.jpa)
    implementation(libs.boot.actuator)
    implementation(libs.boot.validation)
    implementation(libs.springdoc)
    implementation(libs.liquibase)
    runtimeOnly(libs.postgres)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testImplementation(libs.testcontainers.junit)
    testImplementation(libs.testcontainers.postgres)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
