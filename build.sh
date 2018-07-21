cd Exam1
mvn clean install
cd ..
java -classpath "Exam1/target/Exam1-1.0-SNAPSHOT.jar" com.hand.App
echo "Exam1 done"


cd Exam3
mvn clean install
java -jar target/test4.jar
echo "Exam3 done"
cd ..

cd Exam2
mvn clean install
cd ..
echo "服务器启动，但客户端不知道怎么起"
java -classpath "Exam2/target/Exam1-1.0-SNAPSHOT.jar" com.hand.Server
java -classpath "Exam2/target/Exam1-1.0-SNAPSHOT.jar" com.hand.Client
echo "Exam2 done"

echo "JavaTest2 done"
echo "Thanks!"

