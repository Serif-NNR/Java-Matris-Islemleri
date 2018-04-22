
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Alt extends JPanel{
	
	private JLabel bilgi,bilgi2;
	private JButton hesapla , temizle;
	private Matris_Gosterimi birinci,ikinci;
	private Hesaplama_Sonuc hs;
	private int satir1,satir2,sutun1,sutun2;
	private Root_Class rc;
	private boolean hesaplandi = false;
	
	public Alt(Root_Class rc){
		this.rc = rc;
		this.setBackground(Color.MAGENTA);
		this.setLayout(new GridLayout(1,4));
		Panel_Items();
	}
	
	private void  Panel_Items(){
		bilgi = new JLabel("Free Software: https://fsf.org ");
		hesapla = new JButton("Hesapla");
		temizle = new JButton("Temizle");
		bilgi2 = new JLabel("  http://sinanir.com");
		
		
		
		
		Button_Listeners();
		
		this.add(bilgi);
		this.add(hesapla);
		this.add(temizle);
		this.add(bilgi2);
	}
	
	public void Matrisleri_Gonder(Matris_Gosterimi birinci , Matris_Gosterimi ikinci){
		this.birinci = birinci;
		this.ikinci = ikinci;
	}
	
	public void Hesaplama_Kismi(Hesaplama_Sonuc hs){
		this.hs = hs;
	}
	
	public void setMatrisBoyut(int satir1,int satir2,int sutun1,int sutun2){
		this.satir1=satir1;
		this.satir2=satir2;
		this.sutun1=sutun1;
		this.sutun2=sutun2;
	}
		
	
	
	
	
	private void Button_Listeners(){
		
		hesapla.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  
	    	  Islemler islem = new Islemler(birinci.Matrisi_Ver(),ikinci.Matrisi_Ver());
	    	  islem.Boyut_Belirle(satir1, sutun2);
	    	  //JOptionPane.showMessageDialog(null, "HATA BİR");
	    	  //JOptionPane.showMessageDialog(null, String.valueOf(birinci.Matrisi_Ver()[0][0]));
	    	  hs.Top_Matris_Boyut(satir1, sutun1);
	    	  
	    	  if(birinci.Matris_Doldu_Mu()==true && ikinci.Matris_Doldu_Mu()==true && hesaplandi==false){

	    		  hesaplandi = true;
	    		  
	    		  // CARPMA ISLEMİ
	    		  if(sutun1 != satir2){
	    			  
	    			  hs.setCarpim("Bu matrisler çarpılamazlar.");
	    			  //rc.revalidate();
	    		  }
	    		  else{
	    			  // CARPMA YAPACAK KISIM
	    			  //hs.setCarpim("Çarpmıyorum lan!");
	    			  hs.Carpma_Ekle(islem.Carpma_Yap(satir1, sutun1, sutun2),satir1,sutun2);
	    			  //rc.revalidate();
	    			  
	    		  }
	    		  
	    		  // TOPLAMA ISLEMI
	    		  if(satir1==satir2 && sutun1==sutun2){
	    			  // TOPLAM YAPACAK KISIM
	    			  
	    			  hs.Toplama_Ekle(islem.Toplama_Yap());
	    			  hs.sone_ekle();
	    			  rc.revalidate();
	    			  
	    		  }
	    		  else{
	    			  hs.setToplam("Bu matrisler toplanamazlar.");
	    			  hs.sone_ekle();
	    			  rc.revalidate();
	    		  }
	    		  
	    		  
	    	  }
	    	  else if(hesaplandi==true){
	    		  JOptionPane.showMessageDialog(null, "Belirtilen matrisler için hesaplama işlemi zaten yapılmış.\nYeni işlem yapmak için \"Temizle\" butonunu kullan.");
	    	  }
	    	  else{
	    		  JOptionPane.showMessageDialog(null, "Matrislerinizin boş elemanı bulunmakta.\nKontrol edin.");
	    	  }
	      }
	    });
		
		
		temizle.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  JOptionPane.showMessageDialog(null, "Bu buton çalışmıyor.\nVicdani İşçi");
	    	  
	    	  //hesaplandi = false;  
	    	  // Matrisler boşaltılınca bu ibare eklenecek.
	      }
	    });
		
	}
	
	
	
	
	
	
	
	
	public JPanel Uygula(){
		return this;
	}
	
}
