package grpc.service2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import grpc.service2.newServiceGrpc.newServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class NewClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int port = 50057;
		String host ="localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//create an asynchronous stub for the client streaming
		newServiceStub asyncStub = newServiceGrpc.newStub(newChannel);
		
		CountDownLatch latch = new CountDownLatch(1);
		
		StreamObserver<confirmation> responseObserver = new StreamObserver<confirmation>() {

			@Override
			public void onNext(confirmation value) {
				// TODO Auto-generated method stub
				System.out.println("Response: " + value.getConfirmation());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Completed");
				latch.countDown();
			}
			
		};
		
		StreamObserver<credentials> requestObserver = asyncStub.generatePIN(responseObserver);
		
		System.out.println("sending message 1");
		requestObserver.onNext(credentials.newBuilder().setPassword("123abc").build());
		System.out.println("sending message 2");
		requestObserver.onNext(credentials.newBuilder().setPassword("123abc").build());
		
		requestObserver.onCompleted();
		
		try {
			latch.await(3L, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		Thread.sleep(5000);
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
