
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Ust extends JPanel{
	
	private int satir1,satir2,sutun1,sutun2,girdi1,girdi2;
	
	private JLabel matris_boyut1,matris_boyut2,bilgi1,bilgi2;
	private JTextField eleman1,eleman2;
	private JButton eleman_ata1,eleman_ata2,oto_eleman_ata1,oto_eleman_ata2;
	
	private int s_satir1=1,s_satir2=1,s_sutun1=1,s_sutun2=1;
	
	private Matris_Gosterimi birinci,ikinci;
	
	public Ust(int satir1,int satir2,int sutun1,int sutun2){
		this.satir1 = satir1;
		this.satir2 = satir2;
		this.sutun1 = sutun1;
		this.sutun2 = sutun2;
		
		Getir();
		Matris_Boyutlari();
		Bilgilendirme();
		Eleman_Girdileri();
		Eleman_Ata();
		Oto_Eleman_Ata();
		
		Add_Items();
		
		Button_Listeners();
	}
	
	private void Getir(){
		this.setLayout(new GridLayout(2,4));
		this.setBackground(Color.lightGray);
	}
	
	public void Matris_Gosterimleri(Matris_Gosterimi birinci , Matris_Gosterimi ikinci){
		this.birinci = birinci;
		this.ikinci = ikinci;
	}
	
	private void Matris_Boyutlari(){
		matris_boyut1 = new JLabel("1. Matris: ["+satir1+","+sutun1+"]");
		matris_boyut2 = new JLabel("2. Matris: ["+satir2+","+sutun2+"]");
	}
	private void Bilgilendirme(){
		bilgi1 = new JLabel("["+s_satir1+","+s_sutun1+"] Elemanı girin: ");
		bilgi2 = new JLabel("["+s_satir2+","+s_sutun2+"] Elemanı girin: ");
	}
	private void Eleman_Girdileri(){
		eleman1 = new JTextField(5);
		eleman2 = new JTextField(5);
	}
	private void Eleman_Ata(){
		eleman_ata1 = new JButton("Elemanı Ata");
		eleman_ata2 = new JButton("Elemanı Ata");
	}
	private void Oto_Eleman_Ata(){
		oto_eleman_ata1 = new JButton("Otomatik Doldur");
		oto_eleman_ata2 = new JButton("Otomatik Doldur");
	}
	
	private void Add_Items(){
		this.add(matris_boyut1);
		this.add(bilgi1);
		this.add(eleman1);
		this.add(eleman_ata1);
		this.add(oto_eleman_ata1);
		
		this.add(matris_boyut2);
		this.add(bilgi2);
		this.add(eleman2);
		this.add(eleman_ata2);
		this.add(oto_eleman_ata2);
	}
	
	
	
	private void Button_Listeners(){
		
		eleman_ata1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 if(eleman1.getText().equals("")){
	    		 JOptionPane.showMessageDialog(null, "1. Matris için eleman kutusunu boş bıraktın.\nAtama işlemi gerçekleşemedi.","Eksik Girdi",JOptionPane.INFORMATION_MESSAGE);
	    	 }
	    	 else{
	    		 try{
	    			 girdi1 = Integer.parseInt(eleman1.getText());
	    			 Matris1_Doldu();
	    			 if(birinci.Matris_Doldu_Mu()==true){
	    				 JOptionPane.showMessageDialog(null,"1. Matris tamamiyle doldu.");
	    			 }
	    			 else{
	    				 //JOptionPane.showMessageDialog(null, String.valueOf(satir1)+","+String.valueOf(s_satir1));
	    				 
	    				 if(s_sutun1 == sutun1){
	    					 MatrisBilgi_Guncelle();
		    				 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
		    				 birinci.Matris_Doldur(girdi1,s_satir1,s_sutun1);
	    					 s_sutun1=1;
	    					 s_satir1++;	 
	    				 }
	    				 else{
	    					 MatrisBilgi_Guncelle();
		    				 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
		    				 birinci.Matris_Doldur(girdi1,s_satir1,s_sutun1);
	    					 s_sutun1++;
	    				 }
	    			 }
	    			 
	    			 
	    			 Bosalt();
	    		 }
	    		 catch(Exception h){
	    			 JOptionPane.showMessageDialog(null, "Eleman girdisini tamsayı olarak yapmayı dene.","Hatalı Girdi",JOptionPane.ERROR_MESSAGE);
	    			 Bosalt();
	    		 }
	    	 }
	      }
	    });
		
		eleman_ata2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if(eleman2.getText().equals("")){
		    		 JOptionPane.showMessageDialog(null, "2. Matris için eleman kutusunu boş bıraktın.\nAtama işlemi gerçekleşemedi.","Eksik Girdi",JOptionPane.INFORMATION_MESSAGE);
	    	  }
	    	  else{
	    		  try{
	    			  girdi2 = Integer.parseInt(eleman2.getText());
		    			 
		    			 if(ikinci.Matris_Doldu_Mu() == true){
		    				 Matris2_Doldu();
		    				 JOptionPane.showMessageDialog(null,"2. Matris tamamiyle doldu.");
		    			 }
		    			 else{
		    				 
		    				 
		    				 if(s_sutun2 == sutun2){
		    					 MatrisBilgi_Guncelle();
			    				 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir2)+","+String.valueOf(s_sutun2));
			    				 ikinci.Matris_Doldur(girdi2,s_satir2,s_sutun2);
		    					 s_sutun2=1;
		    					 s_satir2++;	 
		    				 }
		    				 else{
		    					 MatrisBilgi_Guncelle();
			    				 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir2)+","+String.valueOf(s_sutun2));
			    				 ikinci.Matris_Doldur(girdi2,s_satir2,s_sutun2);
		    					 s_sutun2++;
		    				 }
		    			 }
		    			 
		    			 
		    			 
		    			 Bosalt();
		    		 }
		    		 catch(Exception h){
		    			 JOptionPane.showMessageDialog(null, "Eleman girdisini tamsayı olarak yapmayı dene.","Hatalı Girdi",JOptionPane.ERROR_MESSAGE);
		    			 Bosalt();
		    		 }
	    	  }
	      }
	    });
		
		
		
		
		oto_eleman_ata1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Random rnd = new Random();
	    	  while(birinci.Matris_Doldu_Mu()==false){
	    		  if(s_sutun1 == sutun1){
 					 MatrisBilgi_Guncelle();
 					 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
 					 birinci.Matris_Doldur(rnd.nextInt(10),s_satir1,s_sutun1);
 					 s_sutun1=1;
 					 s_satir1++;	 
 				 }
 				 else{
 					 MatrisBilgi_Guncelle();
 					 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
 					 birinci.Matris_Doldur(rnd.nextInt(10),s_satir1,s_sutun1);
 					 s_sutun1++;
 				 }
	    	  }
	    	  
	    	  if(birinci.Matris_Doldu_Mu()==true){
		    		 JOptionPane.showMessageDialog(null, "1. Matris şu an dolu.");
		    		 oto_eleman_ata1.setEnabled(false);
		    	 }
	    	 
	    	  rnd = null;
	    	  Matris1_Doldu();
		    	 
	    	 
	      }
	    });
		
		oto_eleman_ata2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Random rnd = new Random();
	    	  while(ikinci.Matris_Doldu_Mu()==false){
	    		  if(s_sutun2 == sutun2){
 					 MatrisBilgi_Guncelle();
 					 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
 					 ikinci.Matris_Doldur(rnd.nextInt(10),s_satir2,s_sutun2);
 					 s_sutun2=1;
 					 s_satir2++;	 
 				 }
 				 else{
 					 MatrisBilgi_Guncelle();
 					 //JOptionPane.showMessageDialog(null, String.valueOf(s_satir1)+","+String.valueOf(s_sutun1));
 					 ikinci.Matris_Doldur(rnd.nextInt(10),s_satir2,s_sutun2);
 					 s_sutun2++;
 				 }
	    		  
		    	  
		    	  
	    	  }
	    	  
	    	  if(ikinci.Matris_Doldu_Mu()==true){
	    		  JOptionPane.showMessageDialog(null,"2. Matris şu an dolu.");
	    		  oto_eleman_ata2.setEnabled(false);
	    	  }
	    	
	    	  Matris2_Doldu();
	    	  rnd = null;
	    	  
	    	  
	    	  
	      }
	    });
		
	}
	
	private void Bosalt(){
		eleman1.setText("");
		eleman2.setText("");
	}
	private void MatrisBilgi_Guncelle(){
		bilgi1.setText("["+s_satir1+","+s_sutun1+"] Elemanı girin: ");
		bilgi2.setText("["+s_satir2+","+s_sutun2+"] Elemanı girin: ");
	}
	private void Matris1_Doldu(){
		bilgi1.setText("1. Matris doldu.");
		eleman_ata1.setEnabled(false);
	}
	private void Matris2_Doldu(){
		bilgi2.setText("2. Matris doldu.");
		eleman_ata2.setEnabled(false);
	}
	
	public JPanel Uygula(){
		return this;
	}
	
}
