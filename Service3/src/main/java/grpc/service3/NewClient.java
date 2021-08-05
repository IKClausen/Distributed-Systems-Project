package grpc.service3;

import java.util.concurrent.TimeUnit;

import grpc.service3.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {
	
	public static void main(String[] args) throws InterruptedException {

		// channel - Generic code to create channel 
		
		int port = 50051; 
		String host = "localHost"; 
		
	   ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(); 
	   
	   // messages
	   balanceRequest br = balanceRequest.newBuilder().setRequest("Fingers crossed").build(); 
	   
	   // Creating stub, passing channel to stub - stub is specific to service 
	   
	   newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel); 
	   
	   balanceResponse response = bstub.viewBalance(br); 
	   
	   System.out.println(response.getBalance());
	   
	   newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	
	}

	
}
