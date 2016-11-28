FROM openjdk
EXPOSE 8080
ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar
ADD ./dist/restlet-json.jar /srv/restlet-json.jar
ADD ./dist/json.jar /srv/json.jar
ADD ./dist/json-20131018.jar /srv/json-20131018.jar
ADD ./dist/QuizMasterServerJava.jar /srv/QuizMasterServerJava.jar
CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/json.jar:/srv/app.jar:/srv/json-20131018.jar api.CodeQuizServer
