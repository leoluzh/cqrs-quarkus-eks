# defaul shell
SHELL = /bin/bash
HUB_USER=leoluzh
IMAGE_VERSION=latest
# Rule "help"
.PHONY: help
.SILENT: help
help:
	echo "Use make [rule]"
	echo "Rules:"
	echo ""
	echo "build-app 	                  - build application"
	echo "build-docker-jvm 		          - build docker image with java jvm"
	echo "push-docker-jvm		          - publish docker image in docker hub"
	echo "build-docker-legacy-jar	      - build docker image with legacy java"
	echo "push-docker-legacy-jar	      - publish docker image in docker hub"
	echo "build-docker-native		      - build docker image with native code (graalvm)"
	echo "push-docker-native		      - publish docker image in docker hub"
	echo "build-docker-native-distroless  - build docker image with native code (graalvm)"
	echo "push-docker-native-distroless	  - publish docker image in docker hub"
	echo ""
	echo "help		    - show this message"

build-app:
	./mvnw clean install;

build-docker-jvm:
	./mvnw clean package; \
	docker build -f src/main/docker/Dockerfile.jvm -t $(HUB_USER)/transaction-service-jvm:$(IMAGE_VERSION) .

push-docker-jvm:
	docker push $(HUB_USER)/transaction-service-jvm:$(IMAGE_VERSION)

build-docker-legacy-jar:
	./mvnw clean package -Dquarkus.package.type=legacy-jar; \
	docker build -f src/main/docker/Dockerfile.legacy-jar -t $(HUB_USER)/transaction-service-legacy-jar .

push-docker-legacy-jar:
	docker push $(HUB_USER)/transaction-service-legacy-jar:$(IMAGE_VERSION)

build-docker-native:
	./mvnw clean package -Pnative; \
	docker build -f src/main/docker/Dockerfile.native -t $(HUB_USER)/transaction-service .

push-docker-native:
	docker push $(HUB_USER)/transaction-service:$(IMAGE_VERSION)

build-docker-native-distroless:
	./mvnw clean package -Pnative; \
	docker build -f src/main/docker/Dockerfile.native-distroless -t $(HUB_USER)/transaction-service .

push-docker-native-distroless:
	docker push $(HUB_USER)/transaction-service:$(IMAGE_VERSION)

