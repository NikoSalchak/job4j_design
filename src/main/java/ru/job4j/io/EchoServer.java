package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger SERVER = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = input.readLine();
                    if (string.contains("msg=Exit")) {
                        server.close();
                    } else if (string.contains("msg=Hello")) {
                        output.write("Hello\r\n\r\n".getBytes());
                    } else {
                        output.write(string.split(" ")[1].split("=")[1].getBytes());
                        output.write("\r\n\r\n".getBytes());
                    }
                    output.flush();
                }
            }
        } catch (Exception e) {
            SERVER.error("Exception socket", e);
        }
    }
}
