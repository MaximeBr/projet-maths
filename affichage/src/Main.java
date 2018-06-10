import java.util.Scanner;

public class Main {
	
	static int N = 6;
	static int NB_POINTS = 10;
	//public static float [] X;
	//public static float [] Y;
	
	public static float [] X = { 36, 40, 32, 32, 41, 35 };
	public static float [] Y = { 0.9F, 1.2F, 0.6F , 0.5F , 1.4F , 1 };
	//float [] Z = {3.9F , 3.7F , 3.2F , 3.1F , 3.6F , 3.7F };
	
	public static float a;
	public static float b;

	
     public static void main(String[] args) {
    	 
    	 
//       PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
//       demo.pack();
//       demo.setVisible(true);
    	 
    //	 X = new float[NB_POINTS];
    	// Y = new float[NB_POINTS];
    	 
    	// entrerNombre();
    	 
    	 
    	 regressionLineaire();
            
         test t = new test("ce genre de graphe q", "s");
         t.pack();
         t.setVisible(true);
            
     }
     
     private static void entrerNombre() {
    	 
    	 int i = 0;
    	 Scanner s = new Scanner(System.in);
    	 System.out.println("nb de points : ");
    	 int nb = s.nextInt();
    	 while (i < nb ) {
    		 System.out.println("entrez les X");
    		 X[i] = s.nextFloat();
    		 i++;
    	 }
    	 i = 0;
    	 while (i < nb ) {
    		 System.out.println("entrez les Y");
    		 Y[i] = s.nextFloat();
    		 i++;
    	 }
     }
     
     private static void regressionLineaire() {
    		int i ;
    		float c;
    		float d;
    		float mx;
    		float my;
    		float mcx;
    		float mcy;
    		float mxy;
    		float varx;
    		float vary;
    		float sigx;
    		float sigy;
    		float cov;
    		float svx = 0;
    		float svy = 0;
    		float scx = 0;
    		float scy = 0;
    		float sxy = 0;
    		
    		
    			
    		//X = new float [N];
    		//Y = new float [N];
    		
    		for (int cpt = 0 ;cpt < N ; cpt ++ ) {
    			c = X[cpt];
    			d = Y[cpt];
    			svx = svx + c;
    			svy = svy + d;
    			sxy = sxy + c*d;
    			scx = scx + c*c;
    			scy = scy + d*d;
    		}
    		
    		mx = svx/N;
    		my = svy/N;
    		mcx = scx/N;
    		mcy = scy/N;
    		mxy = sxy/N;
    		varx = mcx - mx*mx;
    		vary = mcy - my*my;
    		sigx = (float) Math.sqrt(varx);
    		sigy = (float) Math.sqrt(vary);
    		cov = mxy - mx*my;
    		float corr = cov / (sigx*sigy);
    		
    		// coeef de la droite
    		a = cov / varx ;
    		
    		//float b = mx - ((cov/varx)*my);
    		b = my - a * mx;
    		
    		System.out.println(corr);
    		System.out.println(a);
    		System.out.println(b);
     }
}