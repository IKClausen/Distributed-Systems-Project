package grpc.service4;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grpc.service3.viewBalance;
import grpc.service4.*;
import grpc.service4.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Service4GUI {

private static newServiceBlockingStub blockingStub; 
	
	private JFrame frame; 
	private JTextField textName1; 
	private JTextArea textResponse; 
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Service4GUI window = new Service4GUI(); 
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace(); 
				}
			}
			
		}); 

	
	}
	public Service4GUI() {
		int port = 50053; 
		String host = "localhost"; 
		
		ManagedChannel newchannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(); 
		
		// Stub - generated from proto 
		blockingStub = newServiceGrpc.newBlockingStub(newchannel); 
		
		initialize(); 
	}
	private void initialize() {
		
		   frame = new JFrame(); 
		   frame.setTitle("Client - Service Controller"); 
		   frame.setBounds(100, 100, 500, 300);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   // Box layout 
		   BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS); 
		   
		   frame.getContentPane().setLayout(bl); 
		   
		   JPanel panel_service_1 = new JPanel(); 
		   frame.getContentPane().add(panel_service_1); 
		   // FLoy layout - sizing, horizontal layout and wrap
		   panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		   
		   // Creating label and adding to panel 
		   JLabel lblNewLabel_1 = new JLabel("Opt in for account notifications/alerts? - Type Yes"); 
		   panel_service_1.add(lblNewLabel_1); 
		   // Input textbox 
		   textName1 = new JTextField(); 
		   panel_service_1.add(textName1); 
		   
		   textName1.setColumns(10); 
		   
		   JButton btnSend = new JButton("Send to Server"); 
		   
		   // Button action listener 
		   btnSend.addActionListener(new ActionListener() {
			   @Override 
			   public void actionPerformed(ActionEvent e) {
				   
				   // Data from GUI 
				   String accountA = textName1.getText(); 
				   // adapting to method 
				   
				   accountAlerts request = accountAlerts.newBuilder().setRequest.build(); 
				   accountAlerts response = blockingStub.getRequest(Request); 
				   
				  //  Populate the JTextArea 
				   textResponse.append("Alert = Account is empty" + response.getRequest());
				   System.out.println("Alert: " + response.getRequest()); 
				   
			   }
		   }); 
		   
		   panel_service_1.add(btnSend); 
		   
		   textResponse = new JTextArea(3, 20); 
		   textResponse.setLineWrap(true);
		   textResponse.setWrapStyleWord(true);
		   
		   JScrollPane scrollPane = new JScrollPane(textResponse); 
		   panel_service_1.add(scrollPane); 
		   
		
		
		
	}
	
} 
