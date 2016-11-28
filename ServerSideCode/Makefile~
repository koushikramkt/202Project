
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar CodeQuizServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/app.jar api.CodeQuizServer

compile: 
	javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json-20131018.jar:dist/json.jar -d build \
	src/QuizMachine/*.java \
	src/api/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json-20131018.jar:dist/json.jar api.CodeQuizServer

loadtest:
	echo Starting Load Test on localhost
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json-20131018.jar:dist/json.jar RunLoadTest 5

docker-build: app
	docker build -t ServerSideCode .
	docker images

docker-clean:
	docker stop ServerSideCode
	docker rm ServerSideCode
	docker rmi ServerSideCode

docker-run:
	docker run --name ServerSideCode -td ServerSideCode
	docker ps

docker-run-host:
	docker run --name ServerSideCode -td --net=host ServerSideCode
	docker ps

docker-run-bridge:
	docker run --name ServerSideCode -td -p 80:8080 ServerSideCode
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop ServerSideCode
	docker rm ServerSideCode

docker-shell:
	docker exec -it ServerSideCode bash 
	
