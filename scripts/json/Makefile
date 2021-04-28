# defaul shell
SHELL = /bin/bash

# Rule "help"
.PHONY: help
.SILENT: help
help:
	echo "Use make [rule]"
	echo "Rules:"
	echo ""
	echo "add-expense-transaction - add an expense transaction into transaction service"
	echo "add-income-transaction  - add an income transaction into transaction service"
	echo ""
	echo "check		     - check tools versions"
	echo "help		     - show this message"

add-expense-transaction:
	curl -X POST -H "Content-Type: application/json" -d @expense-transaction.json http://localhost:8080/transaction-service/api/v1/transactions

add-income-transaction:
	curl -X POST -H "Content-Type: application/json" -d @income-transaction.json http://localhost:8080/transaction-service/api/v1/transactions
