
import javax.swing.*;

import java.awt.*;

public class Root_Class extends JFrame{

	// ÖZELLİKLER ve OBJELER
	private JPanel ust;
	private Ust ust_kisim;	
	private JPanel sag;
	private JPanel sol;
	private Matris_Gosterimi goster1;
	private Matris_Gosterimi goster2;	
	private Hesaplama_Sonuc hs;	
	private Alt alt_kisim;
	private int satir1,sutun1,satir2,sutun2;
	
	public static void main(String[] args) {
		Root_Class toor = new Root_Class();
	}
	
	public Root_Class(){
		this.setTitle("Matris İşlemleri");
		this.setSize(850, 520);
		Matris_Boyutlari();
		
		ust_kisim = new Ust(satir1,satir2,sutun1,sutun2);
		
		this.add(ust_kisim.Uygula(),BorderLayout.PAGE_START);
		
		goster1 = new Matris_Gosterimi("   1. Matris Elemanları   ",satir1,sutun1);
		goster2 = new Matris_Gosterimi("   2. Matris Elemanları   ",satir2,sutun2);
		this.add(goster1.Uygula(),BorderLayout.LINE_START);
		this.add(goster2.Uygula(),BorderLayout.LINE_END);
		ust_kisim.Matris_Gosterimleri(goster1, goster2);
		
		
		hs = new Hesaplama_Sonuc();
		this.add(hs.Uygula(),BorderLayout.CENTER);
		
		
		alt_kisim = new Alt(this);
		alt_kisim.setMatrisBoyut(satir1,satir2,sutun1,sutun2);
		alt_kisim.Matrisleri_Gonder(goster1,goster2);
		alt_kisim.Hesaplama_Kismi(hs);
		
		this.add(alt_kisim.Uygula(),BorderLayout.PAGE_END);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	
	private void Matris_Boyutlari(){
		JOptionPane.showMessageDialog(null, "Birinci ve İkinci matrislerin boyutlarını belirledikten sonra programa giriş yapabilirsiniz.");
		try{
			satir1=Integer.parseInt(JOptionPane.showInputDialog("Birinci matris satır: "));
			sutun1=Integer.parseInt(JOptionPane.showInputDialog("Birinci matris sutunu: "));
			satir2=Integer.parseInt(JOptionPane.showInputDialog("İkinci matris satır: "));
			sutun2=Integer.parseInt(JOptionPane.showInputDialog("İkinci matris sutunu: "));
		}
		catch(Exception hata){
			JOptionPane.showMessageDialog(null, "Bana hatalı girdi verdin.\nBaşa yönlendiriliyorsun.\nKolay gelsin..");
			Matris_Boyutlari();
		}
	}
	

}
