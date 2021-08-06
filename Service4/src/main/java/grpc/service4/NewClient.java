package grpc.service4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.service4.newServiceGrpc.newServiceBlockingStub;
import grpc.service4.newServiceGrpc.newServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class NewClient {

			
			public static void main(String[] args) throws InterruptedException {
                //Discovery 
				// channel - Generic code to create channel 
				ServiceInfo serviceInfo; 
				String service_type = "_grpc._tcp.local."; 
				
				serviceInfo = ServiceDiscovery.run(service_type); 
				
				int port = 50052; 
				String host = "localHost"; 
				
			   ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(); 
			   
			   // messages
			   alertRequest ar = alertRequest.newBuilder().setRequest("Fingers crossed").build(); 
			   
			   // Creating stub, passing channel to stub - stub is specific to service 
			   // Asynch  
			   newServiceStub asyncstub = newServiceGrpc.newStub(newChannel); 
			   
			   CountDownLatch latch = new CountDownLatch(1); 
			   
				StreamObserver<alertResponse> responseObserver = new StreamObserver<alertResponse>() {

					@Override
					public void onNext(alertResponse value) {
						// TODO Auto-generated method stub
						System.out.println("Alert: " + value.getAlerts());
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("Have a nice day");
						latch.countDown();
					} 
		
			};
			
			
			responseObserver.onCompleted();
			try {
				latch.await(3L, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			       Thread.sleep(5000);
			
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
			
}
