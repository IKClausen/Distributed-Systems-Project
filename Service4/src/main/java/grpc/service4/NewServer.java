package grpc.service4;



import java.io.IOException;

import grpc.service4.NewServer;
import grpc.service4.newServiceGrpc.newServiceImplBase;
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
	    String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		ServiceRegistration ssr = new ServiceRegistration(); 
		
	     ssr.run(port, service_type, service_name); 
		
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
				System.out.println("Alert Request" + alertRequest); 
				
				
				//Response 
				
				alertResponse.Builder response = alertResponse.newBuilder(); 
				response.setAlerts("Alert Request" + response); 
				
				//Send out message
				responseObserver.onNext(response.build());
				
				response.setAlerts("Still E M P T Y: ");
				responseObserver.onNext(response.build());
				
				
				response.setAlerts("Dont buy that!: ");
				responseObserver.onNext(response.build());
				//Output 
				responseObserver.onNext(response.build());
				
				responseObserver.onCompleted();
				
			}
		}


}

