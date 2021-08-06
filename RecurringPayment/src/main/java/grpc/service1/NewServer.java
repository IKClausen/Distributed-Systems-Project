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
		
		int port = 50056;
		String service_type = "_grpc._service1.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		final NewServer ourServer = new NewServer();
		ourServer.start();

	}

	private void start() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Server");
		int port = 50056;
		
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	
	}
	
	// Extend abstract base class for our implementation
		static class NewServerImpl extends newServiceImplBase {
		
			//Unary
			
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
			
			
			//Client Streaming
			@Override
			public StreamObserver<paymentDetails>setRecurringPayment(StreamObserver<confirmation> responseObserver) {
				System.out.println("inside streaming implementation");
				return new StreamObserver<paymentDetails>() {

					@Override
					public void onNext(paymentDetails value) {
						System.out.println("Message received from client: " + value.getName());
						System.out.println("Message received from client: " + value.getAccount());
						System.out.println("Message received from client: " + value.getAmount());
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}
					
					//Client has indicated to server that it has finished streaming
					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						
						confirmation.Builder response = confirmation.newBuilder();
						
						response.setConfirmation("Message from server, streaming now completed!");
						
						responseObserver.onNext(response.build());
						responseObserver.onCompleted();
						
					}
				};
			}
		}
}
