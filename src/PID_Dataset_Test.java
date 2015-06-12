import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;

public class PID_Dataset_Test {
	private static double yes_probability(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8)
    {
        double p=0;
        double p1,p2,p3,p4,p5,p6,p7,p8;
        double w1,w2,w3,w4,w5,w6,w7,w8;
        if (num1 <= 50){
            p1 = 0.007;
            w1 = 33.333;
        }
        else if (num1 <= 100){
            p1 = 0.067;
            w1 = 8.654;
        }
        else if (num1 <= 150){
            p1 = 0.534;
            w1 = 34.541;
        }
        else{
            p1 = 0.392;
            w1 = 75;
        }
        if (num2 <= 60){
            p2 = 0.146;
            w2 = 24.684;
        }
        else if (num2 <= 80){
            p2 = 0.567;
            w2 = 34.157;
        }
        else if (num2 <= 100){
            p2 = 0.257;
            w2 = 45.395;
        }
        else{
            p2 = 0.03;
            w2 = 61.538;
        }

        if (num3 <= 100){
            p3 = 0.586;
            w3 = 29.9;
        }
        else if (num3 <= 200){
            p3 = 0.243;
            w3 = 41.1;
        }
        else if (num3 <= 300){
            p3 = 0.093;
            w3 = 52.1;
        }
        else{
            p3 = 0.078;
            w3 = 56.8;
        }
        if (num4 < 30){
            p4 = 0.198;
            w4 = 17.492;
        }
        else if (num4 < 40){
            p4 = 0.601;
            w4 = 43.631;
        }
        else{
            p4 = 0.201;
            w4 = 56.25;
        }
        if (num5 <= 0.5){
            p5 = 0.53;
            w5 = 28.921;
        }
        else if (num5 <= 1){
            p5 = 0.362;
            w5 = 42.92;
        }
        else if (num5 <= 2){
            p5 = 0.097;
            w5 = 55.319;
        }
        else{
            p5 = 0.011;
            w5 = 75;
        }
        if (num6 <= 20){
            p6 = 0;
            w6 = 0;
        }
        else if (num6 <= 30){
            p6 = 0.336;
            w6 = 21.6;    
        }
        else if (num6 <= 40){
            p6 = 0.284;
            w6 = 48.4;
        }
        else if (num6 <= 50){
            p6 = 0.239;
            w6 = 56.6;
        }
        else if (num6 <= 60){
            p6 = 0.116;
            w6 = 57.4;
        }
        else{
            p6 = 0.026;
            w6 = 25.9;
        }
        if (num7 <= 4){
            p7 = 0.507;
            w7 = 27.642;
        }
        else if (num7 <= 8){
            p7 = 0.313;
            w7 = 44.211;
        }
        else if (num7 <= 12){
            p7 = 0.146;
            w7 = 54.167;
        }
        else{
            p7 = 0.034;
            w7 = 64.286;
        }
        if (num8 <= 40){
            p8 = 0.862;
            w8 = 33.285;
        }
        else if (num8 <= 60){
            p8 = 0.131;
            w8 = 48.611;
        }
        else{
            p8 = 0.007;
            w8 = 100;
        }
        //p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8* 0.4*w1*w2*w3*w4*w5*w6*w7*w8;
        p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8* 0.4;
        return p;
    }
    private static double no_probability(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8)
    {
        double p = 0;
        double p1, p2, p3, p4, p5, p6,p7,p8;
        double w1,w2,w3,w4,w5,w6,w7,w8;
        if (num1 <= 50){
            p1 = 0.008;
            w1 = 66.667;}
        else if (num1 <= 100){
            p1 = 0.38;
            w1 = 91.346;}
        else if (num1 <= 150){
            p1 = 0.542;
            w1 = 65.459;}
        else{
            p1 = 0.07;
            w1 = 25;
        }
        if (num2 <= 60){
            p2 = 0.238;
            w2 = 75.316;}
        else if (num2 <= 80){
        	w2 = 65.843;
            p2 = 0.586;}
        else if (num2 <= 100){
        	w2 = 54.605;
            p2 = 0.166;}
        else{
        	w2 = 38.462;
            p2 = 0.01;
        }
        if (num3 <= 100){
        	w3 = 70.1;
            p3 = 0.736;}
        else if (num3 <= 200){
        	w3 = 58.9;
            p3 = 0.186;}
        else if (num3 <= 300){
        	w3 = 47.9;
            p3 = 0.046;}
        else{
            p3 = 0.032;
            w3 = 43.2;
        }
        if (num4 < 30){
        	w4 = 82.508;
            p4 = 0.5;}
        else if (num4 < 40){
            p4 = 0.416;
            w4 = 56.369;}
        else{
            p4 = 0.084;
            w4 = 43.75;
        }
        if (num5 <= 0.5){
            p5 = 0.698;
            w5 = 71.079;}
        else if (num5 <= 1){
            p5 = 0.258;
            w5 = 57.08;}
        else if (num5 <= 2){
            p5 = 0.042;
            w5 = 44.681;}
        else{
            p5 = 0.002;
            w5 = 25;
        }
        if (num6 <= 20){
            p6 = 0;
            w6 = 0;}
        else if (num6 <= 30){
            p6 = 0.654;
            w6 = 78.4;}
        else if (num6 <= 40){
            p6 = 0.162;
            w6 = 51.6;}
        else if (num6 <= 50){
            p6 = 0.098;
            w6 = 43.4;}
        else if (num6 <= 60){
            p6 = 0.046;
            w6 = 42.6;}
        else{
            p6 = 0.04;
            w6 = 74.1;}

        if (num7 <= 4){
            p7 = 0.712;
            w7 = 72.358;}
        else if (num7 <= 8){
            p7 = 0.212;
            w7 = 55.789;}
        else if (num7 <= 12){
            p7 = 0.066;
            w7 = 45.833;}
        else{
            p7 = 0.01;
            w7 = 35.714;}
        if (num8 <= 40){
        	w8 = 66.715;
            p8 = 0.926;}
        else if (num8 <= 60){
            p8 = 0.074;
            w8 = 51.389;
        }
        else{
            p8 = 0.0;
            w8 = 0;}
        //p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8*0.6*w1*w2*w3*w4*w5*w6*w7*w8;
        p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8*0.6;
        return p;
    }
	public static void test (int test_number)throws NumberFormatException, IOException {		
		CsvReader reader = new CsvReader("PID_dataset _test .csv",',',Charset.forName("GBK"));
		double p1,p2,n1,n2,n3,n4,n5,n6,n7,n8;
		int res,predict;
		int y_n = 0,n_y = 0;
		int correct = 0,incorrect=0;
		reader.readHeaders();
		while(reader.readRecord()&&test_number!=0){
			n1 = Double.parseDouble(reader.get("col1"));
			n2 = Double.parseDouble(reader.get("col2"));
			n3 = Double.parseDouble(reader.get("col3"));
			n4 = Double.parseDouble(reader.get("col4"));
			n5 = Double.parseDouble(reader.get("col5"));
			n6 = Double.parseDouble(reader.get("col6"));
			n7 = Double.parseDouble(reader.get("col7"));
			n8 = Double.parseDouble(reader.get("col8"));
			p1 = yes_probability(n1,n2,n3,n4,n5,n6,n7,n8);
			p2 = no_probability(n1,n2,n3,n4,n5,n6,n7,n8);
			if(p1>p2)
				predict = 1;
			else {
				predict = 0;
			}
			System.out.println("p1:"+p1+"   p2:"+p2+"   Predict:"+predict);
			res = Integer.parseInt(reader.get("col9"));
			if(predict == res)
				correct++;
			else {
				incorrect++;
				if(res==1)
					y_n++;
				else {
					n_y++;
				}
			}
			test_number--;
		}
		System.out.println("Correct:"+correct);
		System.out.println("Incorrect:"+incorrect);
		//System.out.println(correct+incorrect);  
		BigDecimal cor = new BigDecimal(correct);
		BigDecimal total = new BigDecimal(correct+incorrect);
		System.out.println("YesToNo:"+y_n+"   NoToYes:"+n_y);
		//System.out.println(cor.divide(total));
	}

public static void main(String[] args) {	
	try {
		test(768);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

