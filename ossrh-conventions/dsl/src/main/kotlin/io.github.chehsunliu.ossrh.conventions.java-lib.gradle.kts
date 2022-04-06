plugins {
    id("io.github.chehsunliu.ossrh.conventions.java-common")
    `java-library`
    `maven-publish`
    signing
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("OSSRH ${project.name.capitalize()}")
                description.set("Description of ${project.name}")
                url.set("https://github.com/chehsunliu/ossrh")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("chehsunliu")
                        name.set("Che-Hsun Liu")
                        email.set("chehsunliu@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/chehsunliu/ossrh.git")
                    developerConnection.set("scm:git:ssh://github.com/chehsunliu/ossrh.git")
                    url.set("https://github.com/chehsunliu/ossrh")
                }
            }
        }
    }

    repositories {
        maven {
            val snapshotUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            val stagingUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")

            url = if (version.toString().endsWith("SNAPSHOT")) snapshotUrl else stagingUrl
            credentials {
                username = System.getenv("MY_OSSRH_USERNAME") ?: ""
                password = System.getenv("MY_OSSRH_PASSWORD") ?: ""
            }
        }
    }
}

signing {
    val signingKeyId: String? by project
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)

    sign(publishing.publications["maven"])
}
