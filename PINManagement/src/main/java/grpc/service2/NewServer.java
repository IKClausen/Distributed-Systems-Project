package grpc.service2;


import grpc.service2.newServiceGrpc.newServiceImplBase;
import java.io.IOException;

import grpc.service2.NewServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		int port = 50061;
		String service_type = "_grpc._service2.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		final NewServer ourServer = new NewServer();
		ourServer.start();
		
	}
	
	private void start() throws IOException, InterruptedException {
		
		System.out.println("Starting gRPC Server");
		int port = 50061;
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	static class NewServerImpl extends newServiceImplBase {
		
		@Override
		public StreamObserver<credentials>generatePIN(StreamObserver<confirmation> responseObserver) {
			System.out.println("inside streaming implementation");
			return new StreamObserver<credentials>() {

				@Override
				public void onNext(credentials value) {
					System.out.println("Message received from client: " + value.getPassword());
					
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
		
		// Bi-directional
		
		@Override
		
		public StreamObserver<credentials> changePIN(final StreamObserver<authentication> responseObserver) {
			System.out.println("inside streaming implementation");
			return new StreamObserver<credentials>() {
				
				int count;
				@Override
				public void onNext(credentials value) {
					
					count++;
					// TODO Auto-generated method stub
					System.out.println("credentials sent, number of times sent: " + count);
					authentication reply1 = authentication.newBuilder().setAuthentication("First confirmation " + count + " :").build();
					responseObserver.onNext(reply1);
					if (count>2) {
						authentication reply2 = authentication.newBuilder().setAuthentication("Second confirmation " + count + " :").build();
						responseObserver.onNext(reply2);
					}
					

					
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					
					authentication reply1 = authentication.newBuilder().setAuthentication("Streaming completed").build();
					responseObserver.onNext(reply1);
					responseObserver.onCompleted();
					System.out.println("Authentication completed: no of messages received: " + count);
				}

					
			};
		}
	}
}
