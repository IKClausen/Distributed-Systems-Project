package grpc.service4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;



public class ServiceDiscovery {
	private int port; 
	private String host; 
	
	// Listener 
	public static class MyListener implements ServiceListener {
		private int port; 
		private String host; 
		private ServiceInfo serviceInfo; 
		public void serviceAdded(ServiceEvent event) {
			
			System.out.println("\nService added: " + event.getInfo()); 
		}
		
       public void serviceRemoved(ServiceEvent event) {
			
			System.out.println("\nService removed: " + event.getInfo()); 
		}
       
       
       public void serviceResolved(ServiceEvent event) {
			
			System.out.println("\nService Resolved: " + event.getInfo()); 
			ServiceInfo serviceInfo = event.getInfo(); 
			this.setServiceInfo(serviceInfo); 
			
			System.out.println("port " + serviceInfo.getPort());
			this.setPort(serviceInfo.getPort());
		}
    private int getPort() {
		return port;
	   }   

    
	private void setPort(int port) {
		// TODO Auto-generated method stub
		this.port = port; 
		
	}
	
	
    private ServiceInfo getServiceInfo() {
    	return serviceInfo; 
    }
	private void setServiceInfo(ServiceInfo serviceInfo) {
		// TODO Auto-generated method stub
		this.serviceInfo = serviceInfo; 
		
	}
	

	public static ServiceInfo run(String service_type) {
		int port = 0; 
		ServiceInfo serviceInfo = null; 
        JmDNS jmdns = null;
		try {
			jmdns = JmDNS.create(InetAddress.getLocalHost());
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		MyListener msl = new MyListener(); 
		jmdns.addServiceListener(service_type, msl);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		serviceInfo = msl.getServiceInfo();
		port = msl.getPort();
		System.out.println("This is the port retreived from jmDNS: " + port);
		
		try {
			jmdns.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceInfo;
	}
	

	}

	public static ServiceInfo run(String service_type) {
		// TODO Auto-generated method stub
		return null;
	} 
} 
