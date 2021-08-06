package grpc.service4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {

	public void run(int port, String service_type, String service_name) throws UnknownHostException, IOException {
		// Jmdns instance 
		
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
		
		int service_port = port;
		String service_desc = "test jmDNS integration with gRPC";
		
		// Service information object 
		ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc); 
		
		try {
			jmdns.registerService(serviceInfo);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	    System.out.printf("registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
		
		//sleep for 10 seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nService Registered");
	}

}
