# java 基础考试2
## Exam2
实现一个Socket服务器端和一个Socket客户端，先启动服务器端，当客户端连接上来后，将第一题中得到的
SampleChapter1.pdf通过Stream发送给客户端，客户端接收并保存在本地。
要求：
客户端和服务端需要在同一个项目底下。通过命令行运行两次，jar 包后台运行。先后启动服务端和客
户端。（2分）
服务端读取的pdf 需要通过相对路径指定到上一题中的/tmp 文件夹。（2分）
保存后的pdf 文件 在子模块更目录下/tmp 文件夹下，保存的文件名为SampleChapter1.pdf。需要保证
保存后的pdf文件能正常打开。（2分）
客户端收到pdf 并保存成功后，需要断开连接。结束客户端和服务端的进程。（2分）