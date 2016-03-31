# CORBA-GitHub-Client
This is a simple Github Client written in Java which implements CORBA and Dynamic Invocation

To run this application:
1. Start the name server (Terminal 1)
    - tnameserv -ORBInitialPort 1050
2. Compile all Java Files
    - javac -cp ".;gson-2.2.2.jar" *.java
3. Run the Server (Terminal 2)
    - java -cp ".;gson-2.2.2.jar" GitHubServer -ORBInitialPort 1050
4. Run the Client (Terminal 3)
    - java -cp ".;gson-2.2.2.jar" GitHubClient -ORBInitialPort 1050
