import javax.swing.JOptionPane;


public class Islemler {
	
	private int[][] matris1,matris2;
	private int satir,sutun;
	private int[][] toplam;
	private int[][] carpma;
	
	public Islemler(int[][] matris1 , int[][]matris2){
		this.matris1 = matris1;
		this.matris2 = matris2;
	}
	
	public void Boyut_Belirle(int satir,int sutun){
		this.satir = satir;
		this.sutun= sutun;
		toplam = new int[satir][sutun];
	}
	
	public int[][] Toplama_Yap(){	
		//JOptionPane.showMessageDialog(null, String.valueOf(satir));
		for(int i=0;i<satir;i++){
			for(int j=0;j<sutun;j++){
				toplam[i][j] = matris1[i][j] + matris2[i][j];
			}
		}
		return toplam;
	}
	
	
	
	
	public int[][] Carpma_Yap(int satir1 , int sutun1 , int sutun2){
		
		carpma = new int[satir1][sutun2];
		int hucre_islem = 0;
		for(int i=0;i<satir1;i++){
			for(int j=0;j<sutun2;j++){
				for(int a =0;a<sutun1;a++){
					hucre_islem += matris1[i][a]*matris2[a][j];
				}
				carpma[i][j] = hucre_islem;
				hucre_islem = 0;
			}
		}
		//JOptionPane.showMessageDialog(null, "HATA");
		return carpma;
	}
	
	
	
	
}
