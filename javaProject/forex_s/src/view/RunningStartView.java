package view;

import forex.service.forexController;

public class RunningStartView {

	public static void main(String[] args) {
		

	      
	      // 1. ó�� ������ ���̺� ������ ���� �ʱ�ȭ �ܰ�
	      //forexController.req(0);
	      
	      // 2. ������� ����� �����͸� DB�� �ִ� �ܰ�
	      //forexController.req(1);
	      
	      // 3. ���� �ֱ� �����͸� DB�� �߰��ϴ� ���
/*	     forexController.req(2);
	      forexController.insLoad("INSFOREX");
	      forexController.insLoad("INSUSDKRW");
	      */
		

		System.out.println("***** ��� ȯ������ �˻� �˻� *****");
		forexController.getAllForex();

		System.out.println("\n***** ���� 10�� ȯ������ �˻� *****");
		forexController.getForex();
		
		System.out.println("\n***** rownum ���� ȯ������ ���� *****");
		forexController.delForex(6);
		//����
		forexController.getAllForex();
		
		
		System.out.println("\n***** ��� USDKRW ȯ������ �˻� *****");
		forexController.getAllUSDKRW();
		
		System.out.println("\n***** rownum �� USDKRW now, daymin, daymax�˻� *****");
		forexController.getUSDKRW(12);
		forexController.getUSDKRW(5);
		forexController.getUSDKRW(8);
		
		System.out.println("\n***** rownum ���� USDKRW ȯ������ ���� *****");
		forexController.delusdkrw(8);
		//����
		forexController.getAllUSDKRW();
		
	
	}

}
