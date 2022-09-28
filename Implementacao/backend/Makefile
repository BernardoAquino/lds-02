up:
	docker-compose down
	docker-compose up -d mysqldb
	mvn package --file ./rentacar_api
	docker build -t rentacar_api ./rentacar_api
	docker-compose up