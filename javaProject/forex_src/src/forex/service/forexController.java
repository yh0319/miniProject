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
	// 모든 환율정보 검색 로직
	/*
	 * 요청시 발생 가능한 경우의 수 1. 데이터가 있다 2. 진행 프로젝트가 없다, 데이터가 없다 3. 서버 문제 발생(db접속 문제 또는
	 * 개발자의 실수로 sql문장 오류...)
	 */

	public static void getAllForex() {
		ArrayList<forexDTO> allForex = null;
		try {
			allForex = forexDAO.getAllForex();

			if (allForex.size() != 0) {
				RunningEndView.allListView(allForex);

			} else {
				RunningEndView.showSuccess("요청하신 데이터들은 미존재합니다");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}

	// 모든 환율정보 중 최근 10개
	public static void getForex() {
		ArrayList<forexDTO> topTen = null;

		try {
			topTen = forexDAO.getForex();

			if (topTen.size() != 0) {
				RunningEndView.forexListView(topTen);

			} else {
				RunningEndView.showSuccess("요청하신 데이터들은 미존재합니다.");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("최근 10개 환율 정보 검색시 에러 발생");
		}
	}

	// 환율정보 rownum으로 삭제(delete)
	public static void delForex(int rowno) {
		boolean forex = true;
		try {
			forex = forexDAO.deleteForex(rowno);

			if (forex = true) {
				RunningEndView.usdkrwListView(forex);
			} else {
				RunningEndView.showSuccess("삭제할 데이터가 존재하지 않습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("usdkrw 데이터 삭제시 에러 발생");
		}
	}

	// 모든 usdkrw 검색
	public static void getAllUSDKRW() {
		ArrayList<USDKRWDTO> allER = null;

		try {
			allER = USDKRWDAO.getAllUSDKRW();

			if (allER.size() != 0) {
				RunningEndView.usdkrwAllListView(allER);

			} else {
				RunningEndView.showSuccess("요청하신 데이터들은 미존재합니다");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}

	// ? USDKRW 에서 rownum으로 now값, daymin, daymax 검색하기
	public static void getUSDKRW(int rowno) {
		USDKRWDTO usdkrw = null;

		try {
			usdkrw = USDKRWDAO.getUSDKRW(rowno);

			if (usdkrw != null) {
				RunningEndView.usdkrwListView(usdkrw);

			} else {
				RunningEndView.showSuccess("요청하신 데이터들은 미존재합니다");
			}

		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	}

	// ? rownum으로 usdkrw 삭제
	public static void delusdkrw(int rowno) {
		boolean usdkrw = true;
		try {
			usdkrw = USDKRWDAO.deleteUsdKrw(rowno);

			if (usdkrw = true) {
				RunningEndView.usdkrwListView(usdkrw);
			} else {
				RunningEndView.showSuccess("삭제할 데이터가 존재하지 않습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("usdkrw 데이터 삭제시 에러 발생");
		}
	}

}
