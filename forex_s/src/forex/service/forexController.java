package forex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import forex.model.USDKRWDAO;
import forex.model.forexDAO;
import forex.model.dto.USDKRWDTO;
import forex.model.dto.forexDTO;
import view.RunningEndView;

public class forexController {

	private static forexController instance = new forexController();

	public forexController() {
	}

	public static forexController getInstance() {
		return instance;
	}
/*
	public static void req(int i) {
	      forexDAO f = new forexDAO();
	      USDKRWDAO k = new USDKRWDAO();
	      
	      try {
	         if (i == 0) {
	            k.USDKRWDrop();
	            f.ForexDrop();
	         }else if(i == 1){
	            k.USDKRWLoad();
	            f.ForexLoad();
	         }else if(i == 2){
	            k.USDKRWCurLoad();
	            f.ForexCurLoad();
	            
	         }else if(i == 3){
	            
	         }else if(i == 4){
	            
	         }else if(i == 5){
	            
	         }else if(i == 6){
	            
	         }else if(i == 7){
	            
	         }else if(i == 8){
	            
	         }else if(i == 9){
	            
	         }else if(i == 10){
	            
	         }else if(i == 11){
	            
	         }else if(i == 12){
	            
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	   }
	
	*/
	// ��� ȯ������ �˻� ����
	/*
	 * ��û�� �߻� ������ ����� �� 1. �����Ͱ� �ִ� 2. ���� ������Ʈ�� ����, �����Ͱ� ���� 3. ���� ���� �߻�(db���� ���� �Ǵ�
	 * �������� �Ǽ��� sql���� ����...)
	 */

	public static void getAllForex() {
		ArrayList<forexDTO> allForex = null;
		try {
			allForex = forexDAO.getAllForex();

			if (allForex.size() != 0) {
				RunningEndView.allListView(allForex);

			} else {
				RunningEndView.showSuccess("��û�Ͻ� �����͵��� �������մϴ�");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}

	// ��� ȯ������ �� �ֱ� 10��
	public static void getForex() {
		ArrayList<forexDTO> topTen = null;

		try {
			topTen = forexDAO.getForex();

			if (topTen.size() != 0) {
				RunningEndView.forexListView(topTen);

			} else {
				RunningEndView.showSuccess("��û�Ͻ� �����͵��� �������մϴ�.");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("�ֱ� 10�� ȯ�� ���� �˻��� ���� �߻�");
		}
	}

	// ȯ������ rownum���� ����(delete)
	public static void delForex(int rowno) {
		boolean forex = true;
		try {
			forex = forexDAO.deleteForex(rowno);

			if (forex = true) {
				RunningEndView.usdkrwListView(forex);
			} else {
				RunningEndView.showSuccess("������ �����Ͱ� �������� �ʽ��ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("usdkrw ������ ������ ���� �߻�");
		}
	}

	// ��� usdkrw �˻�
	public static void getAllUSDKRW() {
		ArrayList<USDKRWDTO> allER = null;

		try {
			allER = USDKRWDAO.getAllUSDKRW();

			if (allER.size() != 0) {
				RunningEndView.usdkrwAllListView(allER);

			} else {
				RunningEndView.showSuccess("��û�Ͻ� �����͵��� �������մϴ�");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}

	// ? USDKRW ���� rownum���� now��, daymin, daymax �˻��ϱ�
	public static void getUSDKRW(int rowno) {
		USDKRWDTO usdkrw = null;

		try {
			usdkrw = USDKRWDAO.getUSDKRW(rowno);

			if (usdkrw != null) {
				RunningEndView.usdkrwListView(usdkrw);

			} else {
				RunningEndView.showSuccess("��û�Ͻ� �����͵��� �������մϴ�");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
	}

	// ? rownum���� usdkrw ����
	public static void delusdkrw(int rowno) {
		boolean usdkrw = true;
		try {
			usdkrw = USDKRWDAO.deleteUsdKrw(rowno);

			if (usdkrw = true) {
				RunningEndView.usdkrwListView(usdkrw);
			} else {
				RunningEndView.showSuccess("������ �����Ͱ� �������� �ʽ��ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("usdkrw ������ ������ ���� �߻�");
		}
	}

}
