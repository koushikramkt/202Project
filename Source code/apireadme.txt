javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar -d build \
	QuizMachine/*.java \
	api/*.java


java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar api.CodeQuizServer
