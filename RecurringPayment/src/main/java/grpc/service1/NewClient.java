package grpc.service1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import grpc.service1.newServiceGrpc.newServiceBlockingStub;
import grpc.service1.newServiceGrpc.newServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class NewClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int port = 50054;
		String host = "localhost";
		
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
		
		StreamObserver<paymentDetails> requestObserver = asyncStub.setRecurringPayment(responseObserver);
		
		System.out.println("sending message 1");
		requestObserver.onNext(paymentDetails.newBuilder().setName("John Doe").build());
		System.out.println("sending message 2");
		requestObserver.onNext(paymentDetails.newBuilder().setAccount("XXXXXXXXXXXXXXXXXX").build());
		System.out.println("sending message 3");
		requestObserver.onNext(paymentDetails.newBuilder().setAmount(540.50).build());
		
		requestObserver.onCompleted();
		
		try {
		latch.await(3L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//UNARY 
		
		
		cancelPayment cPayment = cancelPayment.newBuilder().setCancel("test1").build();
		
		//create a blocking stub for the unary rpc
		newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		
		//Calling the server and receiving a response
				cancelled response = bstub.cancelRecurringPayment(cPayment);
				
				System.out.println("Requesting cancellation");
				System.out.println(response.getCancelled());
				
		Thread.sleep(5000);
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
