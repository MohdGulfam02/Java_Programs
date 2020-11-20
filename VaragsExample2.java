
public class VaragsExample2 {

	static void vaTest(String str,int ... v) {
		System.out.print(str+"");
		
		for(int x:v) 
			System.out.print(" "+x);
		System.out.println(" ");
	}
	public static void main(String[] args) {
		
		vaTest("One args :",14);
		vaTest("Three args :",1,10,14);
		vaTest("Five args :",14,5,145,1777,7895);
	}

}
