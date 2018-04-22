
import javax.swing.*;
import java.awt.*;

public class Matris_Gosterimi extends JPanel {
	
	private String baslik;
	
	private JPanel matris_goster;
	
	private boolean dolu = false;
	private int satir,sutun,c=0;
	private int[][] matris;
	
	public Matris_Gosterimi(String baslik , int x , int y){
		this.baslik = baslik;
		this.setBackground(Color.GRAY);
		
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(new GridLayout(3,1));

		
		JLabel matris_tanitim = new JLabel(baslik);
		matris_goster = new JPanel();
		matris_goster.setLayout(new GridLayout(x,y));
		
		satir = x;
		sutun = y;
		matris = new int[x][y];

		matris_tanitim.setForeground(Color.WHITE);
		this.add(matris_tanitim);

		this.add(matris_goster);
		
		
		
		
		
		JLabel bos_durmasin = new JLabel("######################");
		bos_durmasin.setForeground(Color.WHITE);
		this.add(bos_durmasin);
		
		
		
	}
	
	
	public void Matris_Doldur(int deger,int satirA,int sutunA){
		//JOptionPane.showMessageDialog(null, String.valueOf(satir)+","+String.valueOf(sutun));
		matris[satirA-1][sutunA-1] = deger;
		///JOptionPane.showMessageDialog(null, "HATA2");
		matris_goster.add(new JLabel("  "+String.valueOf(deger)+"  "));
		Matris_Eleman_Sayisi_Arttir();
	}
	public void Oto_Matris_Doldur(){
		
	}
	
	private void Matris_Eleman_Sayisi_Arttir(){
		if(c >= satir*sutun-1){
			dolu = true;
		}
		else{
			c++;
		}
	}
	
	public boolean Matris_Doldu_Mu(){
		return dolu;
	}
	
	
	public void Matris_Bosalt(){
		dolu = false;
		c = 0;
	}
	
	
	public int[][] Matrisi_Ver(){
		return matris;
	}
	
	
	public int getSatir(){
		return satir;
	}
	public int getSutun(){
		return sutun;
	}
	
	
	public JPanel Uygula(){
		return this;
	}
	
	
	
}
