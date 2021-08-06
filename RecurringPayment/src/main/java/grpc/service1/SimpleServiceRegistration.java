package grpc.service1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;



public class SimpleServiceRegistration {

	public void run(int port, String service_type, String service_name){
		// TODO Auto-generated method stub
		try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            
            int service_port = port;
            String service_desc = "test integration of jmDNS with gRPC";
            

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
            jmdns.registerService(serviceInfo);
            
            System.out.printf("registering service with type: %s and name: %s on port%d ", service_type, service_name, service_port);

            		//sleep for 10 seconds
        			Thread.sleep(10000);
        			System.out.println("\nService Registered");
        			
        			//unregister the services
        			//jmdns.unregisterAllServices();   //you could also unregister a single service
        			
        			
        		} catch (UnknownHostException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}

        	}

        }
