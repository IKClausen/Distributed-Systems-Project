package grpc.service3;

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
	
	private static class MyServiceListener implements ServiceListener {
		
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
       
       
       
     	public int getPort() {
		return port;
	   }

	   public void setPort(int port) {
		this.port = port;
	  }


	  public ServiceInfo getServiceInfo() {
		return serviceInfo;
	  }

	  public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	  }
	
	
	
	
		
	}
	
	
	public static ServiceInfo run(String service_type) throws UnknownHostException, IOException {
		int port = 0; 
		ServiceInfo serviceInfo = null; 
		
		// Instance of JmDns 
		JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
		
		MyServiceListener msl = new MyServiceListener();		
		jmdns.addServiceListener(service_type, msl);
		
		//sleep for 10 seconds
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
