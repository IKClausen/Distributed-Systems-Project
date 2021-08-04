package grpc.service4;

import grpc.service4.NewServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class NewServer {
	
	private Server server; 
    
	public static void main(String[] args) {
		final NewServer theServer = new NewServer();
   	    theServer.start(); 

	}

	private void start() {
	System.out.println("Starting gRPC Server"); 
		
		int port = 50051; 
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port); 
		
		server.awaitTermination();
	}
	
	//Will it work 


}

