package br.com.businesslayer;

import javax.swing.JOptionPane;

public class While {

	public static void main(String[] args) {
	
		//Tabuada com while.
		int numeros =Integer.parseInt(JOptionPane.showInputDialog("Digite numero"));
		int contador = 1;
		while(contador <13){
			System.out.println(numeros+"x"+contador+":"+numeros*contador);
			contador++;
		}
	}
}
