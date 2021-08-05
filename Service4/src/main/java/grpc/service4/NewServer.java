package grpc.service4;



import grpc.service4.NewServer;
import grpc.service4.newServiceGrpc.newServiceImplBase;
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
			
			
			public void accountAlerts(alertRequest request, StreamObserver<alertResponse> responseObserver) {
				
				//Client 
				String alertRequest = request.getRequest(); 
				System.out.println("Balance Request" + alertRequest); 
				
				
				//Response 
				
				alertResponse.Builder response = alertResponse.newBuilder(); 
				alertResponse.setAlerts("Balance Request" + response); 
				
				//Send out message
				responseObserver.onNext(response.build());
				
				response.setAlerts("Our second response string: ");
				responseObserver.onNext(response.build());
				
				
				response.setAlerts("Our third response string: ");
				responseObserver.onNext(response.build());
				//Output 
				responseObserver.onNext(response.build());
				
				responseObserver.onCompleted();
				
			}
		}


}

