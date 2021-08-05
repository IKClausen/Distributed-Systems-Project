package grpc.service4;

import grpc.service3.balanceRequest;
import grpc.service3.balanceResponse;
import grpc.service3.newServiceGrpc.newServiceImplBase;
import grpc.service4.NewServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

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
	// Extend abstract base class 
		static class NewServerImpl extends newServiceImplBase {
			
			@Override
			public void accountAlerts(alertRequest request, StreamObserver<alertResponse> responseObserver) {
				
				//Client 
				String alertrequest = request.getAlertRequest(); 
				System.out.println("Balance Request" + balanceRequest); 
				
				//Response 
				
				alertResponse.Builder response = alertResponse.newBuilder(); 
				alertResponse.setAlertResponse("E M P T Y"); 
				
				//Output 
				responseObserver.onNext(response.build());
				
				responseObserver.onCompleted();
				
			}
		}


}

