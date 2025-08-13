plugins { id("java-library") }

dependencies {
  api(libs.boot.starter.test)
  api(libs.boot.testcontainers)
  api(libs.testcontainers.junit)
  api(libs.testcontainers.postgres)
}