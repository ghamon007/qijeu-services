#!/bin/bash

if [ $# != 0 ]
then 
	echo "Usage $0"
	exit 1
fi


TARGET_DIR=./target/
LOG_FILE="./qijeu-services_`date +"%Y%m%d%H%M"`.log"
PID_FILE=./`basename %0 .jar`.pid


#Lancement de la compilation 
mvn clean package -Dmaven.test.skip=true
FILE_JAR=`ls $TARGET_DIR/*.jar`
echo "Le jar compile est : $FILE_JAR"

echo "java -Xms256m -Xmx256m -jar $FILE_JAR --spring.profiles.active=test"
nohup java -Xms256m -Xmx256m -jar $FILE_JAR --spring.profiles.active=test > $LOG_FILE 2>&1 &
if [ $? == 0 ]
then 
	echo "Service en cours de demarrage ..."
else 
	echo "Echec de demarrage ..."
	exit 2
fi

exit 0
