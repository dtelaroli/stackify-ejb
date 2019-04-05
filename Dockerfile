FROM openjdk:8-jdk

RUN curl -O https://download.oracle.com/glassfish/4.1.2/release/glassfish-4.1.2.zip -H 'Connection: keep-alive' --compressed \
	&& unzip -o glassfish-4.1.2.zip \
	&& rm glassfish-4.1.2.zip

COPY target/stackify-ejb.war /glassfish4/glassfish/domains/domain1/autodeploy/
COPY src/main/resources/stackify-api.properties / 

RUN sed -i "s|-XX:MaxPermSize=192m|-DSTACKIFY_DOCKER_ENABLED=true|g" /glassfish4/glassfish/domains/domain1/config/domain.xml

EXPOSE 8080
	
CMD ["/glassfish4/bin/asadmin", "start-domain", "-v"]
