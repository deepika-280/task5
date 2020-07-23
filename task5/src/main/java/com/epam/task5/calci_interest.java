package com.epam.task5;

import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.util.logging.LogManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.logging.log4j.*;

public class calci_interest extends Applet implements ActionListener{
	private static final Logger LOGGER=LogManager.getLogger(calci_interest.class);
	private static final long serialVersionUID = 1L;
	JButton Be,Bb;
	JTextField Ta,Tb,Tc,Td,Te;
	JLabel La1,L22,L33;
	JPanel p;
	public void init()
	{
	// TODO start asynchronous download of heavy resources

	La1=new JLabel("Principle amount");
	L22=new JLabel("Time period");
	L33=new JLabel("Rate of interest");
	Be=new JButton("Simple interest");
	Bb=new JButton("compound interest");

	Ta=new JTextField();
	Tb=new JTextField();
	Tc=new JTextField();
	Td=new JTextField();
	Te=new JTextField();
	this.setLayout(new GridLayout(5,2));
	this.add(La1);
	this.add(Ta);
	this.add(La1);
	this.add(Tb);
	this.add(L33);
	this.add(Tc);
	this.add(Be);
	this.add(Td);
	this.add(Bb);
	this.add(Te);
	Be.addActionListener(this);
	Bb.addActionListener(this);

	}
	public void actionPerformed(ActionEvent a)
	{
	double principleamount,t,r,simpleinterest,ci;
	principleamount=Double.parseDouble(Ta.getText());
	t=Double.parseDouble(Tb.getText());
	r=Double.parseDouble(Tc.getText());

	if (a.getSource()==Be)
	{
	simpleinterest=(principleamount*t*r)/100.0;
	Td.setText(String.valueOf(simpleinterest));
	}
	else if(a.getSource()==Bb)
	{
	ci=(principleamount*(Math.pow((1+(r/100.0)),t)));
	Te.setText(String.valueOf(ci));
	}
	LOGGER.info("Principal amount:"+Ta.getText());
	LOGGER.info("Time period:"+Tb.getText());
	LOGGER.info("Rate of interest:"+Tc.getText());
	LOGGER.info("Simple interest:"+Td.getText());
	LOGGER.info("Compound interest:"+Te.getText());
	}

}