package grpc.service1;

import java.util.concurrent.TimeUnit;

import grpc.service1.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int port = 50052;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		cancelPayment cPayment = cancelPayment.newBuilder().setCancel("test1").build();
		
		
		newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		
		//Calling the server and receiving a response
		cancelled response = bstub.cancelRecurringPayment(cPayment);
		
		System.out.println(response.getCancelled());
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
