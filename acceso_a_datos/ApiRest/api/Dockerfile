# Usa la imagen base oficial de Tomcat
FROM tomcat:9-jdk11-openjdk

# Elimina las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu archivo WAR construido con Maven al directorio de aplicaciones de Tomcat
COPY target/api-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/api-1.0-SNAPSHOT.war

# Instala el cliente de MongoDB (si lo necesitas)
# RUN apt-get update && apt-get install -y mongodb-clients

# Instala el conector JDBC de MySQL
RUN apt-get update && apt-get install -y mysql-client && \
    wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.28.tar.gz && \
    tar -xzf mysql-connector-java-8.0.28.tar.gz && \
    cp mysql-connector-java-8.0.28/mysql-connector-java-8.0.28.jar /usr/local/tomcat/lib/mysql-connector-java-8.0.28.jar && \
    rm -rf mysql-connector-java-8.0.28 mysql-connector-java-8.0.28.tar.gz

# Copia tu archivo de configuración de Hibernate a la carpeta de configuración de Tomcat
COPY hibernate.cfg.xml /usr/local/tomcat/conf/hibernate.cfg.xml

# Expone el puerto 8080 para acceder a tu aplicación
EXPOSE 8080

# Ejecuta Tomcat
CMD ["catalina.sh", "run"]