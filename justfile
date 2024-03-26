build:
   mvn -DskipTests clean package

sbom-generate:
  mvn clean cyclonedx:makeAggregateBom

build-image:
   mvn -DskipTests clean package spring-boot:build-image

shell:
  docker run -t -i --rm --entrypoint /bin/bash linuxchina/sbom-demo:latest

attach:
  docker-compose exec linuxchina/sbom-demo /bin/bash