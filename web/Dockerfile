# ETAPA 1: Compilação (Build)
# Usa uma imagem oficial do Maven com Java 17 para compilar o código
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos de configuração e o código fonte
COPY pom.xml .
COPY src ./src

# Executa o comando do Maven para compilar e gerar o arquivo .war (pulando os testes)
RUN mvn clean package -DskipTests

# ETAPA 2: Execução (Runtime)
# Usa a imagem oficial do Tomcat 10 (necessário para jakarta.servlet)
FROM tomcat:10.1-jdk17-openjdk-slim

# Copia o arquivo .war gerado na etapa anterior diretamente para a pasta ROOT do Tomcat
# Isso faz com que a tua aplicação rode na raiz do servidor
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expõe a porta padrão do Tomcat
EXPOSE 8080

# Inicia o servidor Tomcat
CMD ["catalina.sh", "run"]