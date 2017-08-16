package client;
import javax.swing.JFrame;
import javax.swing.UIManager;

import frame.OvalFrame;
import frame.RectFrame;
import frame.TextFrame;
import interfaceObserver.FrameObserver;
import subject.CounterSubject;   

/**   
 * A basic JFC 1.1 based application.  
 */
public class Client extends JFrame
{
    private CounterSubject counter;
    
	public Client()
	{
		setTitle("Counting Application: Observer.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(256,148);
		setVisible(false);
		JButtonIncrease.setText("+");
		getContentPane().add(JButtonIncrease);
		JButtonIncrease.setBounds(24,60,88,30);
		JButtonDecrease.setText("-");
		getContentPane().add(JButtonDecrease);
		JButtonDecrease.setBounds(148,60,88,30);
		FrameObserver textf = new TextFrame();
		TextFrame tt = (TextFrame)textf;
		tt.setVisible(true);
		tt.setBounds(250, 0, 300, 200);
		FrameObserver rectf = new RectFrame();
		RectFrame rr = (RectFrame)rectf;
		rr.setVisible(true);
		rr.setBounds(250, 200, 300, 200);
		FrameObserver ovalf = new OvalFrame();
		OvalFrame oo = (OvalFrame)ovalf;
		oo.setVisible(true);
		oo.setBounds(250, 400, 300, 200);
		counter = new CounterSubject ();
		counter.addObserver(textf);
		counter.addObserver(rectf);
		counter.addObserver(ovalf);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction aSymAction = new SymAction();
		JButtonIncrease.addActionListener(aSymAction);
		JButtonDecrease.addActionListener(aSymAction);
	}

	static public void main(String args[])
	{
		try {
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }

			//Create a new instance of our application's frame, and make it visible.
			(new Client()).setVisible(true);
		} 
		catch (Throwable t) {
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	javax.swing.JButton JButtonIncrease = new javax.swing.JButton();
	javax.swing.JButton JButtonDecrease = new javax.swing.JButton();

	void exitApplication()   
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Client.this)
				JFrameCounter_windowClosing(event);
		}
	}

	void JFrameCounter_windowClosing(java.awt.event.WindowEvent event)
	{		 
		JFrameCounter_windowClosing_Interaction1(event);
	}

	void JFrameCounter_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButtonIncrease)
				JButtonIncrease_actionPerformed(event);
			else if (object == JButtonDecrease)
				JButtonDecrease_actionPerformed(event);	
		}
	}

	void JButtonIncrease_actionPerformed(java.awt.event.ActionEvent event)
	{
		counter.increment();	 
	}

	void JButtonDecrease_actionPerformed(java.awt.event.ActionEvent event)
	{
		counter.decrement();
			 
	}
}
