To install postgres SQL and pgadmin via docker, copy below lines in docker-compost.yml and run docker compose, command "docker-compose up -d"

version: "3.7"
services:
  db:
    container_name: postgres
    image: postgres:12.2
    restart: always
    environment:
      POSTGRES_DB: postgres
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres@123
    ports:
      - "5432:5432"
  pgadmin:
    container_name: pggui
    image: dpage/pgadmin4:4.18
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@vmware.com
      PGADMIN_DEFAULT_PASSWORD: admin@123
      PGADMIN_LISTEN_PORT: 80
    ports:
      - "7000:80"
    links:
      - "db:pgsql-server"


Design Approach --> 

1) The versioning information will be provided as a part of the header, for example - produces = "application/vdm.poc.app-v1+json". The advantage is the URI remains same across the versions and header changes.

2) For each version, there will be separate DTO. The version information will be included in the name of the DTO, for example ManagedDbV1, ManagedDbV2 etc.

3) Irrespective of major or minor version upgrade, api version will move from V1 → V2 → V3 and so on. 

4) The entity remains same across the versions. The entity can change. And if entity changes, we need to change/upgrade DTO accordingly, and how it changes depends on different use cases mentioned below.

5) There will be separate method in controller layer corresponding to each version.

6) Entity to DTO and vice versa conversion is done at controller layer so that code at service and repository layer remains the same across the versions. For this POC I have used Orika mapper to map entity to DTO.
