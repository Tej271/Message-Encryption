import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Stack;
import javax.swing.JTextArea;


public class Encrypter {

	private JFrame frame;
	private final JTextArea msg_textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encrypter window = new Encrypter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Encrypter() {
		initialize();
	}
	
	public String reverser(String Message) {
		Stack<Character> st = new Stack<>();
		for(int i=0;i<Message.length();i++) {
			char ch = Message.charAt(i);
			st.push(ch);
		}
		String rev = "";
		while(!st.isEmpty()) {
			rev= rev+st.pop();
		}
		
		return rev;
	}
	
	public String ascii(String rs) {
		String x="";
		for(int i=0; i<rs.length(); i++){
			if(i<rs.length()-1) {							
				x=x+Integer.toString((int)rs.charAt(i))+"#";
			}
			else {
				x=x+Integer.toString((int)rs.charAt(i));
			}
		}
		return x;
	}
	
	
	public String deCode(String cd) {
		String alpha="";
		int bi=0;
		cd = cd + "#";
		for(int h=0;h<cd.length();h++){
			char ch = '#';
			if(cd.charAt(h)==ch) {
				String temp = Character.toString((char)Integer.parseInt(cd.substring(bi, h)));
				alpha = alpha + temp;
				bi = h+1;
			}
		}
		return alpha;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cryptography");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(294, 10, 207, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel encrypt_panel = new JPanel();
		encrypt_panel.setBounds(10, 100, 367, 267);
		frame.getContentPane().add(encrypt_panel);
		encrypt_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Message");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 26, 66, 19);
		encrypt_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html>Encoded<br>Message</html>");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 155, 66, 38);
		encrypt_panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Go");
		
		
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(306, 56, 51, 30);
		encrypt_panel.add(btnNewButton);
		msg_textArea.setBounds(102, 25, 195, 108);
		encrypt_panel.add(msg_textArea);
		
		JTextArea encode_textArea = new JTextArea();
		encode_textArea.setBounds(100, 149, 195, 108);
		encrypt_panel.add(encode_textArea);
		
//		JTextArea decode_textArea = new JTextArea();
//		decode_textArea.setBounds(100, 149, 195, 108);
//		encrypt_panel.add(decode_textArea);
		
		encode_textArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Message="";
				encode_textArea.setLineWrap(true);
				Message = msg_textArea.getText();
				try {
					String rs = reverser(Message);
					String rsa = ascii(rs);
					encode_textArea.setText(rsa);
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Encryption");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(38, 62, 92, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Decryption");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(430, 65, 102, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JPanel decrypt_panel = new JPanel();
		decrypt_panel.setLayout(null);
		decrypt_panel.setBounds(420, 100, 367, 267);
		frame.getContentPane().add(decrypt_panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Code");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 26, 66, 19);
		decrypt_panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("<html>Decoded<br>Message</html>");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 155, 74, 46);
		decrypt_panel.add(lblNewLabel_1_1_1);
		
		JTextArea code_textArea = new JTextArea();
		code_textArea.setBounds(100, 25, 195, 108);
		decrypt_panel.add(code_textArea);
		
		JTextArea decode_textArea = new JTextArea();
		decode_textArea.setBounds(100, 149, 195, 108);
		decrypt_panel.add(decode_textArea);
		
		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code_textArea.setLineWrap(true);
				String code= code_textArea.getText();
				String dec = deCode(code);
				String result = reverser(dec);
				decode_textArea.setText(result);
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(305, 56, 52, 33);
		decrypt_panel.add(btnNewButton_1);
		
		
	}
}
