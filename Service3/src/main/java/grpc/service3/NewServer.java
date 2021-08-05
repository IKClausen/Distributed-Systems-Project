package grpc.service3;

import java.io.IOException;

import grpc.service3.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
     private Server server; 
     
     public static void main(String[] args) throws IOException, InterruptedException {
    	 
    	 final NewServer theServer = new NewServer();
    	 theServer.start(); 
    	 
    	 
     }

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting gRPC Server"); 
		
		int port = 50051; 
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port); 
		
		server.awaitTermination();
	}

	// Extend abstract base class 
	static class NewServerImpl extends newServiceImplBase {
		
		@Override
		public void viewBalance(balanceRequest request, StreamObserver<balanceResponse> responseObserver) {
			
			//Client 
			String balanceRequest = request.getRequest(); 
			System.out.println("Balance Request" + balanceRequest); 
			
			//Response 
			
			balanceResponse.Builder response = balanceResponse.newBuilder(); 
			response.setBalance("E M P T Y"); 
			
			//Output 
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
			
		}
	}
}
