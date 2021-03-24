// Swing allows you to create Graphical User Interfaces
// You need the Swing library to create GUI interfaces
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;

// You must extend the JFrame class to make a frame

public class MMA extends JFrame implements ItemListener {
	JComboBox c1;
	JTextField textField1;
	
	public static void main(String[] args){
		
		new MMA();
		
	}
	
	public MMA(){
		
		// Define the size of the frame
		this.setSize(300, 200);
		
		// Opens the frame in the middle of the screen---------------------------------------------------
		// You could also define position based on a component                   |
		
		// this.setLocationRelativeTo(null);
		
		
		// Toolkit is the super class for the Abstract Window Toolkit
		// It allows us to ask questions of the OS
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		// A Dimension can hold the width and height of a component
		// getScreenSize returns the size of the screen
		
		Dimension dim = tk.getScreenSize();
		
		// dim.width returns the width of the screen
		// this.getWidth returns the width of the frame you are making
		
		 int xPos = (dim.width) - (this.getWidth());
		 int yPos = (dim.height) - (this.getHeight());
		 
		// You could also define the x, y position of the frame
		 
		 this.setLocation(xPos, yPos);
		
		
		// Define how the user exits the program
		// This closes when they click the close button
		
		// Define if the user can resize the frame (true by default)
		this.setResizable(true);
		
		// Define how the frame exits (Click the Close Button)
		// Without this Java will eventually close the app
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define the title for the frame
		
		this.setTitle("MMA");
		
		// The JPanel contains all of the components for your frame
		
		JPanel thePanel = new JPanel();
		
		// How to create a label with its text ----------
		
		//JLabel label1 = new JLabel("Tell me something");
		
		// How to change the text for the label
		
		//label1.setText("New Text");
		
		// How to create a tool tip for the label
		
		//label1.setToolTipText("Doesn't do anything");
		
		// How to add the label to the panel
		
		//thePanel.add(label1);
		
		// How to create a button -----------------------
		String s1[] = { "Dummy" }; 
		
		c1 = new JComboBox(s1); 
		c1.addItemListener(this);
		thePanel.add(c1);
		 
//		JButton button1 = new JButton("Send");
//		
//		// How to hide the button border (Default True)
//		
//		button1.setBorderPainted(false);
//		
//		// How to hide the button background (Default True)
//		
//		button1.setContentAreaFilled(false);
//		
//		// How to change the text for the label
//		
//		button1.setText("New Button");
//				
//		// How to create a tool tip for the label
//				
//		button1.setToolTipText("Doesn't do anything either");
//		
//		thePanel.add(button1);
		
		// How to add a textfield ----------------------
		
		textField1 = new JTextField("Type Here", 15);
		
		// Change the size of the text field
		
		textField1.setColumns(10);
		
		// Change the initial value of the text field
		
		textField1.setText("New Text Here");
		
		// Change the tool tip for the text field
		
		textField1.setToolTipText("You are Awesome");
		textField1.addKeyListener(new KeyListener1());
		
		thePanel.add(textField1);
		
		// How to add a text area ----------------------
		
		JTextArea textArea1 = new JTextArea(5, 15);
		
		// Set the default text for the text area
		
		textArea1.setText("Dev\nQlty\nTkt\nNonOffice\nMisc");
		textArea1.getDocument().addDocumentListener(new DocumentListener1());
		
		// If text doesn't fit on a line, jump to the next
		
		textArea1.setLineWrap(true);
		
		// Makes sure that words stay intact if a line wrap occurs
		
		textArea1.setWrapStyleWord(true);
		
		// Gets the number of newlines in the text
		
		int numOfLines = textArea1.getLineCount();
		String textInTextArea = textArea1.getText();
		String[] textInTextAreaList = textInTextArea.split("\r?\n");
		System.out.println(Arrays.toString(textInTextAreaList));
		for(String textInTextAreaItem: textInTextAreaList)
			c1.addItem(textInTextAreaItem);
		
		// Appends text after the current text
		
		
		// Adds scroll bars to the text area ----------
		
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER
		
		thePanel.add(scrollbar1);
		
		// How to add the panel to the frame
		
		this.add(thePanel);
		
		// Makes the frame show on the screen
		
		this.setVisible(true);
		
		// Gives focus to the textfield
		
		textField1.requestFocus();
		
		// You can also request focus for the text array
		// textArea1.requestFocus();
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
private class DocumentListener1 implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println(e);
		//DocumentEvent.ElementChange change = e.getChange(e.getDocument().getDefaultRootElement());
		
		int offset = e.getOffset();
		int length = e.getLength();
		try {
			String str = e.getDocument().getText(offset, length);
			if(str.equals("\n")) {
				System.out.println(str);
				System.out.println("Change size = " + e.getLength());
				length = (e.getDocument().getLength());
				String textArea = e.getDocument().getText(0, length -1);
				String[] topics = textArea.split("\r?\n");
				c1.removeAllItems();
				for(String topic: topics)
					c1.addItem(topic);
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
//		if(change.getChildrenAdded() != null)
//			System.out.println(Arrays.toString(change.getChildrenAdded()));
//		if(change.getChildrenRemoved() != null)
//			System.out.println(Arrays.toString(change.getChildrenRemoved()));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println(e);
	}
	
}
private class KeyListener1 implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		char str = e.getKeyChar();
		if(str == '\n') {
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			Instant instance = Instant.ofEpochMilli(millis);
			LocalDateTime localDateTime = LocalDateTime
                    .ofInstant(instance, java.time.ZoneId.of("Asia/Kolkata"));
			ZonedDateTime zonedDateTime = ZonedDateTime
                    .ofInstant(instance,java.time.ZoneId.of("Asia/Kolkata"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("u-M-d, hh:mm:ss a");			//"u-M-d hh:mm:ss a O"
			String zonedTime = zonedDateTime.format(formatter);
			String log = "" + zonedTime + ", " + c1.getItemAt(c1.getSelectedIndex()) + ", " + millis + ", " + textField1.getText();
			System.out.println(log);
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter("C:\\Users\\I341365\\Desktop\\MMA.csv", true));
				bw.write(log + "\n");
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				//nothing
			}
			textField1.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
}