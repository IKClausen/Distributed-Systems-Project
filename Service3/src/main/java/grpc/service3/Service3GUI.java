package grpc.service3;

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

import grpc.service3.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class Service3GUI {

	private static newServiceBlockingStub blockingStub; 
	
	private JFrame frame; 
	private JTextField textName1; 
	private JTextArea textResponse; 
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Service3GUI window = new Service3GUI(); 
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace(); 
				}
			}
			
		}); 

	}
	
	public Service3GUI() {
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
	   JLabel lblNewLabel_1 = new JLabel("View Balance? - Type Yes"); 
	   panel_service_1.add(lblNewLabel_1); 
	   // Input textbox 
	   textName1 = new JTextField(); 
	   panel_service_1.add(textName1); 
	   
	   textName1.setColumns(10); 
	   
	   JButton btnSend = new JButton("Send our message to Server"); 
	   
	   // Button action listener 
	   btnSend.addActionListener(new ActionListener() {
		   @Override 
		   public void actionPerformed(ActionEvent e) {
			   
			   // Data from GUI 
			   String balanceR = textName1.getText(); 
			   // adapting to method 
			   
			   balanceRequest request = balanceRequest.newBuilder().setRequest(balanceR).build(); 
			   balanceResponse response = blockingStub.viewBalance(request); 
			   
			  //  Populate the JTextArea 
			   textResponse.append("Balance = E M P T Y " + response.getBalance());
			   System.out.println("Balance: " + response.getBalance()); 
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
