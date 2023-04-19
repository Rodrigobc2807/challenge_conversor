package com.convierte;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class mone extends JFrame {
	
	JPanel panel01;
	JComboBox combo01;
	JComboBox combo02;
	double resultado=0;
	
	
	public mone() {
		this.setBounds(10, 10, 400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Changelle Conversor");
		iniciarComponentes();
		this.setVisible(true);
		
	}
	
	
	private void iniciarComponentes() {
		agrega_panel();
		arte();
		radio_botones();
	}
	 
	private void agrega_panel() {
		panel01= new JPanel();
		panel01.setLayout(null);
		panel01.setBackground(new java.awt.Color(179, 229, 252));
		this.getContentPane().add(panel01); //Agrega el panel a la ventana
		
	}
	
	
	private void arte() {
		JLabel lab01= new JLabel("Tipo de conversión:");
		lab01.setFont(new Font("Tahoma",Font.BOLD,16));
		lab01.setBounds(10,5,180,40);
		lab01.setBackground(new java.awt.Color(179, 229, 252));
		panel01.add(lab01);
	}
	
	public void radio_botones() {
		String [] moneda= {"Colón","Dolar","Euro","Libra Esterlina","Yen Japones","Won sur-coreano"};
		String [] distancia= {"Kilómetro","Milla"};
		String [] temperatura= {"Celsius","Fahrenheit","Kelvin"};

		combo01= new JComboBox(moneda);
		combo01.setFont(new Font("Tahoma",Font.BOLD,14));
		combo01.setBounds(125, 82, 125, 30);
		panel01.add(combo01);

		combo02= new JComboBox(moneda);
		combo02.setFont(new Font("Tahoma",Font.BOLD,14));
		combo02.setBounds(125, 142, 125, 30);
		panel01.add(combo02);
		
		JLabel result= new JLabel("Resultado: "+resultado);
		result.setFont(new Font("Tahoma",Font.BOLD,14));
		result.setOpaque(true);
		result.setForeground(Color.WHITE);
		result.setBackground(new Color(25, 118, 210));
		result.setBounds(15, 280, 350, 30);
		panel01.add(result);

		JLabel eti01= new JLabel("Convertir de:");
		eti01.setFont(new Font("Tahoma",Font.BOLD,14));
		eti01.setBounds(20, 82, 100, 30);
		panel01.add(eti01);
		
		JLabel eti02= new JLabel("A:");
		eti02.setFont(new Font("Tahoma",Font.BOLD,14));
		eti02.setBounds(80, 142, 100, 30);
		panel01.add(eti02);

		JRadioButton rad01= new JRadioButton("Moneda",true);
		rad01.setBounds(10, 40, 120, 30);
		rad01.setFont(new Font("Tahoma",Font.BOLD,14));
		rad01.setBackground(new java.awt.Color(179, 229, 252));
		panel01.add(rad01);

		ActionListener oyente1= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combo01.removeAllItems();
				combo02.removeAllItems();
				for (int i=0;i<moneda.length;i++) {
					combo01.addItem(moneda[i]);
					combo02.addItem(moneda[i]);
				}

			}
		};
		rad01.addActionListener(oyente1);

		
		
		JRadioButton rad02= new JRadioButton("Temperatura",false);
		rad02.setBounds(125, 40, 120, 30);
		rad02.setFont(new Font("Tahoma",Font.BOLD,14));
		rad02.setBackground(new java.awt.Color(179, 229, 252));
		panel01.add(rad02);

		ActionListener oyente2= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combo01.removeAllItems();
				combo02.removeAllItems();
				for (int i=0;i<temperatura.length;i++) {
					combo01.addItem(temperatura[i]);
					combo02.addItem(temperatura[i]);
				}
			}
		};
		rad02.addActionListener(oyente2);
		
		
		JRadioButton rad03= new JRadioButton("Distancia",false);
		rad03.setBackground(new java.awt.Color(179, 229, 252));
		rad03.setFont(new Font("Tahoma",Font.BOLD,14));
		rad03.setBounds(260, 40, 140, 30);
		panel01.add(rad03);

		ActionListener oyente3= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combo01.removeAllItems();
				combo02.removeAllItems();
				for (int i=0;i<distancia.length;i++) {
					combo01.addItem(distancia[i]);
					combo02.addItem(distancia[i]);
				}
			}
		};
		rad03.addActionListener(oyente3);
	
		ButtonGroup gru01= new ButtonGroup();
		gru01.add(rad01);
		gru01.add(rad02);
		gru01.add(rad03);
		
		JLabel tCant= new JLabel("Cantidad a convertir:");
		tCant.setFont(new Font("Tahoma",Font.BOLD,14));
		tCant.setBounds(20, 200, 150, 30);
		panel01.add(tCant);


		JTextField cantidad= new JTextField();
		cantidad.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent t) {
				char c=t.getKeyChar();
				if (!Character.isDigit(c) && c!='.'){
					t.consume();
				}
			}
		});
		cantidad.setToolTipText("Ingrese el valor a convertir");
		cantidad.setBounds(180, 200, 60, 30);
		panel01.add(cantidad);
		
		JButton botonConvertir= new JButton("Convertir");
		botonConvertir.setBounds(255, 200, 90, 30);
		panel01.add(botonConvertir);

		ActionListener oyente4= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entrada= (String) combo01.getSelectedItem();
				String salida= (String) combo02.getSelectedItem();
				double int_cantidad,int_resultado;
				String txt_cantidad=cantidad.getText();
				int con=0;
				for (int i=0;i<txt_cantidad.length();i++) {
					if (txt_cantidad.charAt(i)=='.'){
							con++;
					}
				}
				if (con>1) {
					JOptionPane.showMessageDialog(null, "Formato de cantidad no válido");
					cantidad.setText("0");
				}
				
				int_cantidad=Double.parseDouble((String)cantidad.getText());
				int_resultado=int_cantidad;
				
				
				if (rad01.isSelected()){
					if (entrada=="Colón") {
						if (salida=="Dolar"){
							int_resultado= int_cantidad/538.79922;
						}else if (salida=="Euro"){
							int_resultado= int_cantidad/594.86038;
						}else if (salida=="Libra Esterlina"){
							int_resultado= int_cantidad/668.89652;
						}else if (salida=="Yen Japones"){
							int_resultado= int_cantidad/4.027077;
						}else if (salida=="Won sur-coreano"){
							int_resultado= int_cantidad/0.411615;
						}
					}

					if (entrada=="Dolar") {
						if (salida=="Colón"){
							int_resultado= int_cantidad*538.79922;
						}else if (salida=="Euro"){
							int_resultado= int_cantidad/1.1040483;
						}else if (salida=="Libra Esterlina"){
							int_resultado= int_cantidad/1.2414578;
						}else if (salida=="Yen Japones"){
							int_resultado= int_cantidad/0.0074741699;
						}else if (salida=="Won sur-coreano"){
							int_resultado= int_cantidad/0.0007639479;
						}
					}
				
					if (entrada=="Euro") {
						if (salida=="Colón"){
							int_resultado= int_cantidad*0.00168107;
						}else if (salida=="Dolar"){
							int_resultado= int_cantidad/0.905757;
						}else if (salida=="Libra Esterlina"){
							int_resultado= int_cantidad/1.12446;
						}else if (salida=="Yen Japones"){
							int_resultado= int_cantidad/0.00676979;
						}else if (salida=="Won sur-coreano"){
							int_resultado= int_cantidad/0.000691952;
						}
					}

					if (entrada=="Libra Esterlina") {
						if (salida=="Colón"){
							int_resultado= int_cantidad*0.00149406;
						}else if (salida=="Dolar"){
							int_resultado= int_cantidad/0.805511;
						}else if (salida=="Euro"){
							int_resultado= int_cantidad/0.888579;
						}else if (salida=="Yen Japones"){
							int_resultado= int_cantidad/0.00602052;
						}else if (salida=="Won sur-coreano"){
							int_resultado= int_cantidad/0.000615793;
						}
					}
					
					if (entrada=="Yen Japones") {
						if (salida=="Colón"){
							int_resultado= int_cantidad*0.248161;
						}else if (salida=="Dolar"){
							int_resultado= int_cantidad/133.794;
						}else if (salida=="Euro"){
							int_resultado= int_cantidad/147.592;
						}else if (salida=="Libra Esterlina"){
							int_resultado= int_cantidad/166.099;
						}else if (salida=="Won sur-coreano"){
							int_resultado= int_cantidad/0.102283;
						}
					}
						result.setText(String.valueOf(String.format("%.2f",int_cantidad)+" "+entrada+" son "+String.format("%.2f",int_resultado)+" "+salida));
				}

				if (rad02.isSelected()){
					if (entrada=="Celsius") {
						if (salida=="Fahrenheit"){
							int_resultado= int_cantidad*1.8+32;
						}else if (salida=="Kelvin"){
							int_resultado= int_cantidad+273.15;
						}
					}

					if (entrada=="Fahrenheit") {
						if (salida=="Celsius"){
							int_resultado= (int_cantidad-32)*5/9;
						}else if (salida=="Kelvin"){
							int_resultado= ((int_cantidad-32)*5/9)+273.15;
						}
					}
				
					if (entrada=="Kelvin") {
						if (salida=="Celsius"){
							int_resultado= int_cantidad-273.15;
						}else if (salida=="Fahrenheit"){
							int_resultado= ((int_cantidad-273.15)*9/5)+32;
						}
					}
					result.setText(String.valueOf(String.format("%,.2f",int_cantidad)+" "+entrada+" son "+String.format("%,.2f",int_resultado)+" "+salida));
				}
			
				if (rad03.isSelected()){
					if (entrada=="Kilómetro") {
						if (salida=="Milla"){
							int_resultado= int_cantidad/1.60934;
						}
					}
					if (entrada=="Milla") {
						if (salida=="Kilómetro"){
							int_resultado= int_cantidad/0.621371;
						}
					}
					result.setText(String.valueOf(String.format("%,.2f",int_cantidad)+" "+entrada+" son "+String.format("%,.2f",int_resultado)+" "+salida));
				}
			}
		};
		botonConvertir.addActionListener(oyente4);
	}
}
