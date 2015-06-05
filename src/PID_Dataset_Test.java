import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;

public class PID_Dataset_Test {
	private static double yes_probability(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8)
    {
        double p=0;
        double p1,p2,p3,p4,p5,p6,p7,p8;
        if (num1 <= 50)
            p1 = 0.007;
        else if (num1 <= 100)
            p1 = 0.067;
        else if (num1 <= 150)
            p1 = 0.534;
        else
            p1 = 0.392;

        if (num2 <= 60)
            p2 = 0.146;
        else if (num2 <= 80)
            p2 = 0.567;
        else if (num2 <= 100)
            p2 = 0.257;
        else
            p2 = 0.03;

        if (num3 <= 100)
            p3 = 0.586;
        else if (num3 <= 200)
            p3 = 0.243;
        else if (num3 <= 300)
            p3 = 0.093;
        else
            p3 = 0.078;

        if (num4 < 30)
            p4 = 0.198;
        else if (num4 < 40)
            p4 = 0.601;
        else
            p4 = 0.201;

        if (num5 <= 0.5)
            p5 = 0.53;
        else if (num5 <= 1)
            p5 = 0.362;
        else if (num5 <= 2)
            p5 = 0.097;
        else
            p5 = 0.011;

        if (num6 <= 20)
            p6 = 0;
        else if (num6 <= 30)
            p6 = 0.336;
        else if (num6 <= 40)
            p6 = 0.284;
        else if (num6 <= 50)
            p6 = 0.239;
        else if (num6 <= 60)
            p6 = 0.116;
        else
            p6 = 0.026;

        if (num7 <= 4)
            p7 = 0.507;
        else if (num7 <= 8)
            p7 = 0.313;
        else if (num7 <= 12)
            p7 = 0.146;
        else
            p7 = 0.034;

        if (num8 <= 40)
            p8 = 0.862;
        else if (num8 <= 60)
            p8 = 0.131;
        else
            p8 = 0.007;

        p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8* 0.359;
        return p;
    }
    private static double no_probability(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8)
    {
        double p = 0;
        double p1, p2, p3, p4, p5, p6,p7,p8;
        if (num1 <= 50)
            p1 = 0.008;
        else if (num1 <= 100)
            p1 = 0.38;
        else if (num1 <= 150)
            p1 = 0.542;
        else
            p1 = 0.07;

        if (num2 <= 60)
            p2 = 0.238;
        else if (num2 <= 80)
            p2 = 0.586;
        else if (num2 <= 100)
            p2 = 0.166;
        else
            p2 = 0.01;

        if (num3 <= 100)
            p3 = 0.736;
        else if (num3 <= 200)
            p3 = 0.186;
        else if (num3 <= 300)
            p3 = 0.046;
        else
            p3 = 0.032;

        if (num4 < 30)
            p4 = 0.5;
        else if (num4 < 40)
            p4 = 0.416;
        else
            p4 = 0.084;

        if (num5 <= 0.5)
            p5 = 0.698;
        else if (num5 <= 1)
            p5 = 0.258;
        else if (num5 <= 2)
            p5 = 0.042;
        else
            p5 = 0.002;

        if (num6 <= 20)
            p6 = 0;
        else if (num6 <= 30)
            p6 = 0.654;
        else if (num6 <= 40)
            p6 = 0.162;
        else if (num6 <= 50)
            p6 = 0.098;
        else if (num6 <= 60)
            p6 = 0.046;
        else
            p6 = 0.04;

        if (num7 <= 4)
            p7 = 0.712;
        else if (num7 <= 8)
            p7 = 0.212;
        else if (num7 <= 12)
            p7 = 0.066;
        else
            p7 = 0.01;

        if (num8 <= 40)
            p8 = 0.926;
        else if (num8 <= 60)
            p8 = 0.074;
        else
            p8 = 0.0;
        p = p1 * p2 * p3 * p4 * p5 * p6 *p7*p8*0.651;
        return p;
    }
	public static void test (int test_number)throws NumberFormatException, IOException {		
		CsvReader reader = new CsvReader("PID_dataset _test .csv",',',Charset.forName("GBK"));
		double p1,p2,n1,n2,n3,n4,n5,n6,n7,n8;
		int res,predict;
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
			res = Integer.parseInt(reader.get("col9"));
			if(predict == res)
				correct++;
			else 
				incorrect++;
			test_number--;
		}
		System.out.println(correct);
		System.out.println(incorrect);
		//System.out.println(correct+incorrect);  
		BigDecimal cor = new BigDecimal(correct);
		BigDecimal total = new BigDecimal(correct+incorrect);
		System.out.println(cor.divide(total));
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

