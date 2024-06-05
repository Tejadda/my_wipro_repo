package com.DAY_25;
import java.io.Serializable;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int num1;
    private int num2;
    private String operation;

    public Operation(int num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }
}
public class TCPServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())
        ) {
            Operation operation = (Operation) input.readObject();
            int result = performOperation(operation);
            output.writeObject(result);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int performOperation(Operation operation) {
        int num1 = operation.getNum1();
        int num2 = operation.getNum2();
        String op = operation.getOperation();

        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Division by zero");
                }
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
    }
}
package com.DAY_25;
import java.io.*;
import java.net.Socket;
public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Create an Operation object
            Operation operation = new Operation(2, 2, "+");

            // Send the Operation object to the server
            output.writeObject(operation);

            // Receive the result from the server
            int result = (int) input.readObject();

            System.out.println("Result from server: " + result);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}