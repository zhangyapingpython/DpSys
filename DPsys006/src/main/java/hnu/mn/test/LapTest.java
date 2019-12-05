package hnu.mn.test;

import hnu.mn.utils.AddLaplaceNoise;

public class LapTest {
	public static void main(String[] args) {
		AddLaplaceNoise addLaplaceNoise=new AddLaplaceNoise();
		int epsilon1=1000;
		double epsilon=epsilon1/100.0;
		double realCountResult=100;
		System.out.println(AddLaplaceNoise.laplaceMechanismCount(realCountResult, epsilon));
	}

	

}
