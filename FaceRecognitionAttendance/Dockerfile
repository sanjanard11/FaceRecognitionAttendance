# -------- Build stage --------
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /build
COPY . .
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# -------- Run stage --------
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Install OpenCV native libs if you need them
RUN apt-get update && apt-get install -y \
    libopencv-core4.5d \
    libopencv-imgproc4.5d \
    libopencv-imgcodecs4.5d \
    libopencv-objdetect4.5d \
    libopencv-videoio4.5d \
    && rm -rf /var/lib/apt/lists/*

# IMPORTANT: put your real JAR name here
COPY --from=builder /build/target/face-recognition-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]