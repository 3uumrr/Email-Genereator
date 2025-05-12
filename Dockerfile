# استخدم صورة مبدئية للجافا
FROM openjdk:17-jdk-slim as builder

# تحديد الدليل الذي يحتوي على المشروع داخل الحاوية
WORKDIR /app

# نسخ ملف pom.xml الخاص بـ Maven
COPY pom.xml .

# تحميل التبعيات باستخدام Maven
RUN mvn dependency:go-offline

# نسخ كل الملفات
COPY src /app/src

# بناء المشروع باستخدام Maven
RUN mvn clean package -DskipTests

# الصورة النهائية لتشغيل التطبيق
FROM openjdk:17-jdk-slim

WORKDIR /app

# نسخ الـ jar الملف الذي تم بناؤه من الـ stage السابق
COPY target/email-writer-sb-0.0.1-SNAPSHOT.jar email-writer-sb.jar

# تحديد الأمر لتشغيل التطبيق
CMD ["java", "-jar", "email-writer-sb.jar"]


