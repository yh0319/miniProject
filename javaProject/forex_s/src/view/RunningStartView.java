package view;

import forex.service.forexController;

public class RunningStartView {

	public static void main(String[] args) {
		

	      
	      // 1. 처음 구동시 테이블 생성을 위한 초기화 단계
	      //forexController.req(0);
	      
	      // 2. 현재까지 모아진 데이터를 DB에 넣는 단계
	      //forexController.req(1);
	      
	      // 3. 가장 최근 데이터를 DB에 추가하는 기능
/*	     forexController.req(2);
	      forexController.insLoad("INSFOREX");
	      forexController.insLoad("INSUSDKRW");
	      */
		

		System.out.println("***** 모든 환율정보 검색 검색 *****");
		forexController.getAllForex();

		System.out.println("\n***** 상위 10개 환율정보 검색 *****");
		forexController.getForex();
		
		System.out.println("\n***** rownum 으로 환율정보 삭제 *****");
		forexController.delForex(6);
		//검증
		forexController.getAllForex();
		
		
		System.out.println("\n***** 모든 USDKRW 환율정보 검색 *****");
		forexController.getAllUSDKRW();
		
		System.out.println("\n***** rownum 별 USDKRW now, daymin, daymax검색 *****");
		forexController.getUSDKRW(12);
		forexController.getUSDKRW(5);
		forexController.getUSDKRW(8);
		
		System.out.println("\n***** rownum 으로 USDKRW 환율정보 삭제 *****");
		forexController.delusdkrw(8);
		//검증
		forexController.getAllUSDKRW();
		
	
	}

}
