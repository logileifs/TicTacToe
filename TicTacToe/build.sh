#!/bin/sh
#cd /home/tester/git/TicTacToe/TicTacToe/
#git pull | grep date

dt=$(date)

while :
do
dt=$(date)
if git pull | grep -lq 'Already up-to-date' ;
then
	echo $dt "- Nothing to do"
else
	if ant all | grep -lq 'BUILD SUCCESSFUL' ;
	then
		cd build/jar/
		java -jar TicTacToe.jar
		if grep -lq 'Enter Player 1 name :' ;
		then
			if quit | grep -lq 'Game Over' ;
			then
			cd ..
			cd ..
			fi
		fi
	fi
fi
sleep 10
done
