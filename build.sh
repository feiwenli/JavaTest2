cd Exam1
mvn clean install
java -classpath "target/test4.jar" com.hand.WalkingDirectory
echo "Exam1 done"
cd ..
cd Exam2
mvn clean install
java -jar target/test4.jar
echo "Exam2 done"
cd ..
cd Exam3
mvn clean install
java -jar target/test4.jar
echo "Exam3 done"
cd ..
echo "JavaTest2 done"
echo "Thanks!"

