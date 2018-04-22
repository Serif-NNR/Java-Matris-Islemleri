
import java.awt.*;

import javax.swing.*;

public class Hesaplama_Sonuc extends JPanel {
	
	private JLabel isim,carpma_sonuc,toplama_sonuc;
	
	private JPanel sonuc_kismi = new JPanel();
	private JPanel toplam_kismi = new JPanel();
	private JPanel carpma_kismi = new JPanel();
	
	private int top_satir,top_sutun;
	
	
	public Hesaplama_Sonuc(){
		
		this.setLayout(new FlowLayout());
		
		this.setBackground(Color.BLACK);
		
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		
		
		isim = new JLabel("Şerif İnanır'ın Ev Ödevi - 160204057");
		isim.setForeground(Color.RED);
		
		JLabel ders = new JLabel("ALKÜ | Programlama Dilleri 2. Ödevi");
		ders.setForeground(Color.CYAN);
		
		this.add(isim);
		this.add(ders);
		
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		this.add(new JLabel("################################################################################"));
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		
		
		JLabel carpma_label = new JLabel("          ISLEM CIKTILARI          ");
		carpma_label.setForeground(Color.LIGHT_GRAY);
		this.add(carpma_label);
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		
		carpma_sonuc = new JLabel("Hesaplama yapılmadı.");
		toplama_sonuc = new JLabel("Hesaplama yapılmadı.");
		carpma_sonuc.setForeground(Color.RED);
		toplama_sonuc.setForeground(Color.RED);
		
		JLabel t = new JLabel("Toplama İşlemi Sonucu:  ");
		JLabel c = new JLabel("Çarpma İşlemi Sonucu:  ");
		t.setForeground(Color.CYAN);
		c.setForeground(Color.cyan);
		
		
		
		sonuc_kismi.setLayout(new GridLayout(2,2));

		this.add(sonuc_kismi);
		//this.add(toplam_kismi);
	
			
	}
	
	public void Top_Matris_Boyut(int satir,int sutun){
		this.top_satir = satir;
		this.top_sutun = sutun;
		toplam_kismi.setLayout(new GridLayout(top_satir,top_sutun));
		carpma_kismi.setLayout(new GridLayout(satir,sutun));
	}
	
	public void Toplama_Ekle(int[][] matris){
		JLabel t = new JLabel("Toplama İşlemi Sonucu:    ");
		t.setForeground(Color.WHITE);
		this.add(t);
		//JOptionPane.showMessageDialog(null, String.valueOf(matris[0][0]));
		toplam_kismi.setLayout(new GridLayout(top_satir,top_sutun));
		for(int i=0;i<top_satir;i++){
			for(int j=0;j<top_sutun;j++){
				//JOptionPane.showMessageDialog(null, "HATA BURADA");
				//JOptionPane.showMessageDialog(null, String.valueOf(matris[i][j]));
				toplam_kismi.add(new JLabel("   "+String.valueOf(matris[i][j])+"   "));
				//JOptionPane.showMessageDialog(null, "HATA YOK");
			}
		}
		toplam_kismi.setBackground(Color.WHITE);
		this.add(toplam_kismi);
		
	}
	
	
	public void sone_ekle(){
		this.add(new JLabel("################################################################################"));
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		this.add(new JLabel("################################################################################"));
		this.add(new JLabel("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
		this.add(new JLabel("################################################################################"));
		JLabel okul = new JLabel("Alanya Alaaddin Keykubat University");
		
		
		okul.setForeground(Color.RED);
		this.add(okul);
		
	}
	
	/*
	public void Toplama_Ekle(String deger){
		toplam_kismi.add(new JLabel(deger));
	}
	*/
	public void Carpma_Ekle(int[][] matris,int satir1,int sutun2){
		//JOptionPane.showMessageDialog(null, "HATA");
		JLabel c = new JLabel("Çarpma İşlemi Sonucu:   ");
		c.setForeground(Color.WHITE);
		this.add(c);
		for(int i=0;i<satir1;i++){
			for(int j=0;j<sutun2;j++){
				carpma_kismi.add(new JLabel("   "+String.valueOf(matris[i][j])+"   "));
			}
		}
		//JOptionPane.showMessageDialog(null, "HATA");
		carpma_kismi.setBackground(Color.WHITE);
		this.add(carpma_kismi);
		this.add(new JLabel("################################################################################"));
		this.add(new JLabel("################################################################################"));
	}
	
	
	
	public void setToplam(String degis){
		this.add(new JLabel(degis));
	}
	public void setCarpim(String degis){
		this.add(new JLabel(degis));
		this.add(new JLabel("################################################################################"));
	}
	
	
	public JPanel Uygula(){
		return this;
	}
	
}
