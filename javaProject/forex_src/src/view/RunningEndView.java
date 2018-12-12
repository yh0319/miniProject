package view;

import java.util.ArrayList;

import forex.model.dto.USDKRWDTO;
import forex.model.dto.forexDTO;

public class RunningEndView {

	public static void showSuccess(String message) {
		System.err.println(message);
	}

	public static void showError(String message) {
		System.out.println(message);
	}

	public static void forexListView(ArrayList<forexDTO> topTen) {
		System.out.println(topTen);
	}

	public static void usdkrwAllListView(ArrayList<USDKRWDTO> allER) {
		System.out.println(allER);
	}

	
	public static void usdkrwListView(boolean usdkrw) {
		System.out.println(usdkrw);
	}

	public static void usdkrwListView(USDKRWDTO usdkrw) {
		System.out.println(usdkrw);
	}

	public static void allListView(ArrayList<forexDTO> allForex) {
		System.out.println(allForex);
	}

}
