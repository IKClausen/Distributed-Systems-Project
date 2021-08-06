package grpc.service2;

import java.awt.EventQueue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import grpc.service2.newServiceGrpc.newServiceBlockingStub;
import grpc.service2.newServiceGrpc.newServiceStub;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewGUIApplication {
	
	private static newServiceStub asyncStub;
	
	private JFrame frame;
	private JTextField textName1;
	private JTextField textName2;
	private JTextArea textResponse;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			//override the run method of runnable
			public void run() {
				try {
					NewGUIApplication window = new NewGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * * Create the application.
	 * */
	public NewGUIApplication() {
		
		int port = 50061;
		String host = "localhost";
		
		ManagedChannel newchannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//stubs -- generate from proto
		asyncStub = newServiceGrpc.newStub(newchannel);
		
		initialize();
		
	}
		
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("Client - Service Controller");
			// set bounds can be done from frames, panels and buttons
			frame.setBounds(100, 100, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Box layout determines how components are laid out in the panel
			//Layout vertically in a col - box layout doesn't wrap
			BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
			
			frame.getContentPane().setLayout(bl);
			
			JPanel panel_service_1 = new JPanel();
			frame.getContentPane().add(panel_service_1);
			//Flow layout - items retain their size, are laid out horizontally and wrap
			panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			//Create new label and add it to the panel
			JLabel lblNewLabel_1 = new JLabel(" Message ");
			panel_service_1.add(lblNewLabel_1);
			
			//Input textbox
			textName1 = new JTextField();
			panel_service_1.add(textName1);
			//How wide should input box be? - doesn't affect number that can be entered
			textName1.setColumns(10);
			
			
			JButton btnSend = new JButton("Send our message to Server");
			
			//Add an action listener to our button
			btnSend.addActionListener(new ActionListener() {
				
				//implement action performed method
				//This will happen when the button is clicked
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//Retrieve data from GUI
					String name1 = textName1.getText();

					//Do some logic with our index or send it over
					
					String data = name1;
					
					
					
					credentials request = credentials.newBuilder().setPassword(data).build();
					confirmation response = asyncStub.generatePIN(request);
					
					System.out.println("Response: " + response.getConfirmation());
					
					//populate the JTextArea in the panel
					textResponse.append("reply:" + response.getConfirmation());
//					System.out.println("response: " + response.getCancelled());
					
								
				
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
