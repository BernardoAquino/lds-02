# FROM maven:3.8.3-openjdk-17

# # Cria os diretórios para as configurações do maven
# RUN mkdir -p /root/.m2 \
#     && mkdir /root/.m2/repository

# # Caso você possua configurações locais do maven, copie-as para um arquivo settings.xml neste diretório
# COPY ./settings.xml /root/.m2

# WORKDIR /rentacar_api
# COPY . .

# RUN mvn clean install

# CMD mvn spring-boot:run

FROM maven:3.8.3-openjdk-17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]