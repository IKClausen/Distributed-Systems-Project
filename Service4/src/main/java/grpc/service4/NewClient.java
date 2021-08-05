package grpc.service4;

import java.util.concurrent.TimeUnit;

import grpc.service4.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {

			
			public static void main(String[] args) {

				// channel - Generic code to create channel 
				
				int port = 50052; 
				String host = "localHost"; 
				
			   ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(); 
			   
			   // messages
			   alertRequest ar = alertRequest.newBuilder().setRequest("Fingers crossed").build(); 
			   
			   // Creating stub, passing channel to stub - stub is specific to service 
			   
			   newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel); 
			   
			   alertResponse response = bstub.accountAlerts(ar)  
			   
			   System.out.println(response.getAlerts());
			   
			   newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
			
			}


    }
