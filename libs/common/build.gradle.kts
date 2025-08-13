plugins { id("java-library") }

dependencies {
    api(libs.boot.validation)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    implementation(libs.boot.web)
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}