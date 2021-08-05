package grpc.service2;


import grpc.service2.newServiceGrpc.newServiceImplBase;
import grpc.service2.NewServiceImpl;
import java.io.IOException;

import grpc.service2.NewServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		final NewServer ourServer = new NewServer();
		ourServer.start();
		
	}
	
	private void start() throws IOException, InterruptedException {
		
		System.out.println("Starting gRPC Server");
		int port = 50058;
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
		
		public StreamObserver<credentials> changePIN(StreamObserver<authentication> responseObserver) {
			System.out.println("inside streaming implementation");
			return new StreamObserver<credentials>() {

				@Override
				public void onNext(credentials value) {
					// TODO Auto-generated method stub
					System.out.println("Message received from client: " + value.getPassword());
					
					String pin = value.getPassword();
					authentication reply = authentication.newBuilder().setAuthentication(pin).build();
					
					responseObserver.onNext(reply);
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Authentication completed ");
					
					responseObserver.onCompleted();
				}

				
	
			};
		}
	}
}
