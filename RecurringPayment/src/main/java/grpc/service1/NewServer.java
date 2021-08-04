package grpc.service1;

import java.io.IOException;

import grpc.service1.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		final NewServer ourServer = new NewServer();
		ourServer.start();

	}

	private void start() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Server");
		
		int port = 50052;
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	
	}
	
	// Extend abstract base class for our implementation
		static class NewServerImpl extends newServiceImplBase {
		
			@Override
			public void cancelRecurringPayment(cancelPayment request, StreamObserver<cancelled> responseObserver) {
				
				//Find out what was sent by client
				String cancel = request.getCancel();
				System.out.println("cancel:" + cancel);
				
				//Now build our response
				
				cancelled.Builder response = cancelled.newBuilder();
				
				response.setCancelled("Payment has been cancelled");
				
				//Send out message
				responseObserver.onNext(response.build());
				
				responseObserver.onCompleted();
			}
		}

}
