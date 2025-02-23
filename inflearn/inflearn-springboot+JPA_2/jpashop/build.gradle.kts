plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
}

group = "jpabook"
version = "0.0.1-SNAPSHOT"
val queryDslVersion = "5.0.0" // QueryDSL Version Setting


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.10.0")
	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.10.0")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate6")
	implementation("com.oracle.database.jdbc:ojdbc11")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

// QueryDSL Implementation
	implementation ("com.querydsl:querydsl-jpa:${queryDslVersion}:jakarta")
	annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:jakarta")
	annotationProcessor("jakarta.annotation:jakarta.annotation-api")
	annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}


tasks.withType<Test> {
	useJUnitPlatform()
}
