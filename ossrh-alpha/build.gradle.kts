plugins {
    id("io.github.chehsunliu.ossrh.conventions.java-lib")
}

dependencies {
    implementation(project(":ossrh-beta"))
    implementation("org.apache.httpcomponents.client5:httpclient5:5.1.3")
}
