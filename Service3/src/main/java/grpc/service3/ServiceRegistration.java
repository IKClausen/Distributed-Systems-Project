package grpc.service3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


public class ServiceRegistration {
	
	public void run(int port, String service_type, String service_name) throws UnknownHostException, IOException, InterruptedException {
		
		// JmDns Instance 
		
		JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
		
		int service_port = port;
		String service_desc = "test jmDNS integration with gRPC";
		
		//Creating service information 
		//Generic method to create the object			
		ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
		
		jmdns.registerService(serviceInfo);
		
		System.out.printf("registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
		
		//sleep for 10 seconds
		Thread.sleep(10000);
		System.out.println("\nService Registered");
		    	
	}

}
