# From tomcate
# copy build/Bank-Management.war
From ubuntu:latest As build
Run apt-get update
Run apt-get install openjdk-17-jdk -y
Run apt-get install tomcat
COPY . .
Run build.xml --no-daemon
Run build/Bank-Management.war



