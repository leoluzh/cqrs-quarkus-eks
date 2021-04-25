# defaul shell
SHELL = /bin/bash

# Rule "help"
.PHONY: help
.SILENT: help
help:
	echo "Use make [rule]"
	echo "Rules:"
	echo ""
	echo "start-services - build application and generate docker image"
	echo "create-topic   - create ebank transaction topic in kafka"
	echo ""
	echo "check		     - check tools versions"
	echo "help		     - show this message"

start-services:
	docker-compose up -d --build

create-topic:
	docker exec -it ebank-kafka \
	  ./bin/kafka-topics.sh --create \
	  --topic transactions \
	  --zookeeper ebank-zookeeper:2181 \
	  --replication-factor 1 \
	  --partitions 3