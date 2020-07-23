package com.epam.task5;
import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.logging.log4j.*;

public class log extends Applet implements ActionListener {
	private static final Logger LOGGER=LogManager.getLogger(log.class);
	private static final long serialVersionUID = 1L;
	JButton b1;
	JTextField tf1,tf2,tf3,tf4;
	JLabel la1,la2,la3;
	JPanel pp;
	public void init()
	{
	// TODO start asynchronous download of heavy resources

	la1=new JLabel("material standard");
	la2=new JLabel("total area");
	la3=new JLabel("fully automated");
	b1=new JButton("calculate cost");
	tf1=new JTextField();
	tf2=new JTextField();
	tf3=new JTextField();
	tf4=new JTextField();
	this.setLayout(new GridLayout(4,2));
	this.add(la1);
	this.add(tf1);
	this.add(la2);
	this.add(tf2);
	this.add(la3);
	this.add(tf3);
	this.add(b1);
	this.add(tf4);
	b1.addActionListener(this);


	}
	public void actionPerformed(ActionEvent ae)
	{

	String materialstandard;
	double totalarea,totalcost=0.0;
	int constructioncost;
	String automated;
	materialstandard=tf1.getText();
	totalarea=Double.parseDouble(tf2.getText());
	automated=tf3.getText().toLowerCase();
	if (ae.getSource()==b1)
	{
	if(materialstandard.equals("standard")) {
	constructioncost=1200;
	totalcost=constructioncost*totalarea;
	}
	else if(materialstandard.equals("above standard")) {
	constructioncost=1500;
	totalcost=constructioncost*totalarea;
	}
	else if(materialstandard.equals("high standard")) {
	constructioncost=1800;
	totalcost=constructioncost*totalarea;
	}
	else if(materialstandard.equals("high standard") && (automated.equals("yes") || automated.equals("true"))) {
	constructioncost=2500;
	totalcost=constructioncost*totalarea;
	}
	tf4.setText(Double.toString(totalcost));
	}
	LOGGER.info("Material standard:"+tf1.getText());
	LOGGER.info("Total area:"+tf2.getText());
	LOGGER.info("Fully automated:"+tf3.getText());
	LOGGER.info("Total cost:"+tf4.getText());
	}
}