FROM 172.16.101.43:5000/base_java8:2.0.0
MAINTAINER chengang <gangchen1@jieyuechina.com>
LABEL Description="esb boot esbmail images "  Version="pro-1.0.0"

VOLUME /data

ADD esbmail.jar /tmp/esbmail.jar
ADD http://172.16.101.32/stgconfig/esbmail/raw/master/src/main/resources/application.properties /tmp/application.properties
ADD http://172.16.101.32/stgconfig/esbmail/raw/master/src/main/resources/logback.xml /tmp/logback.xml

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV LC_ALL "zh_CN.UTF-8"
ENV JAVA_OPTS="-Xms512m -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=128m"

EXPOSE 10063

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /tmp/esbmail.jar --spring.config.location=file:/tmp/application.properties " ]