package grpc.service3;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.service3.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {

		//Discovery  
		ServiceInfo serviceInfo; 
		String service_type = "_grpc._tcp.local."; 
		serviceInfo = ServiceDiscovery.run(service_type); 
		
		int port = serviceInfo.getPort(); 
		
		// int port = 50051; No need for this method as this is done through jnDns discovery
		
		String host = "localHost"; 
		
		// channel - Generic code to create channel 
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
