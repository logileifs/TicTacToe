#!/bin/sh
#cd /home/tester/git/TicTacToe/TicTacToe/

while :
do
dt=$(date)
if git pull | grep -lq 'Already up-to-date' ;
then
	#echo $dt "- Nothing to do" #>> buildlog.txt
	echo $dt "- Nothing to do"
else
	echo $dt > lastbuild.txt
	ant all >> lastbuild.txt
	echo $dt >> buildlog.txt
	ant all >> buildlog.txt
	cat lastbuild.txt
	if cat lastbuild.txt | grep -lq 'BUILD SUCCESSFUL' ;
	then
		git add -f build/jar/TicTacToe.jar
		git commit -m "SUCCESFUL BUILD, PUSHED WORKING JAR FILE TO REPOSITORY"
		git push https://username:password@github.com/Theragon/TicTacToe.git
	fi
fi
sleep 10
done
