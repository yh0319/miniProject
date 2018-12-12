package forex.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import forex.model.util.DBUtil;



public class dAODAO {
	   
	   // �� ó�� ������ �� ����� ���̺��� �����ϴ� �ܰ�
	   public static void initForTable() {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         ArrayList<String> a = new ArrayList<String>();
	         
	         String initForex1 = "drop table forex";
	         String initForex2 = "create table forex(time varchar2(20), USDKRW number(20,5), KRWEUR number(20,5), EURCNY number(20,5),"
	               + "KRWJPY number(20,5), KRWCNY number(20,5), EURKRW number(20,5), GBPEUR number(20,5), JPYKRW number(20,5), GBPUSD number(20,5))";
	         
	         a.add(initForex1);
	         a.add(initForex2);
	         
	         for (String lister : a) {
	            System.out.println(lister);
	            con = null;
	            pstmt = null;
	            rset = null;
	            try{
	               con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
	               pstmt = con.prepareStatement(lister);
	               rset = pstmt.executeQuery();
	               }catch(SQLException s){
	               s.printStackTrace();
	            }finally{
	               DBUtil.close(con, pstmt, rset);
	            }
	         }
	      }
	   
	      public static void initUSDKRWTable() {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rset = null;
	         ArrayList<String> a = new ArrayList<String>();
	         
	         String initUsdKrw1 = "drop table usdkrw";
	         String initUsdKrw2 = "create table usdkrw(time varchar2(20), now number(20,5), changes number(20,5), changespercent number(20,5), "
	               + "daymin number(20,5), daymax number(20,5), yearmin number(20,5), yearmax number(20,5))";
	         
	         a.add(initUsdKrw1);
	         a.add(initUsdKrw2);
	         for (String lister : a) {
	            System.out.println(lister);
	            con = null;
	            pstmt = null;
	            rset = null;
	            try{
	               con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
	               pstmt = con.prepareStatement(lister);
	               rset = pstmt.executeQuery();
	               }catch(SQLException s){
	               s.printStackTrace();
	            }finally{
	               DBUtil.close(con, pstmt, rset);
	            }
	         }
	      }

	      // ���̺� ������� ����� �����͸� �����ϴ� �ܰ�
	      // FOREX �� USDKRW �̹Ƿ�, �ѹ��� �� �� ����Ǿ�� ��
	      // ��) �� DAO���� initLoad(FOREX); �� initLoad(USDKRW); ���� ����־�� ��
	      public static void initLoad(String fileName) {
	         try {
	            Thread.sleep(1000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         String concatFileInfo = "C:\\0.ITStudy\\2.java\\forexdb\\" + fileName;
	         System.out.println(concatFileInfo);
	         String sqlldr = "";
	         try {
	            sqlldr = "sqlldr userid=SCOTT/TIGER control="+ concatFileInfo +".ctl";
	            Process filename = Runtime.getRuntime().exec(sqlldr);
	            BufferedReader br = new BufferedReader(new InputStreamReader(filename.getInputStream()));
	            String line = null;
	            while ((line = br.readLine()) != null) {
	               System.out.println(line);
	            }
	            filename.waitFor();
	         } catch (IOException e) {
	            e.printStackTrace();
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      // ���� �ֱ��� �����͸� ���̺� append �ϴ� �ܰ�
	      public static void insLoad(String fileName) {
	            String concatFileInfo = "C:\\0.ITStudy\\2.java\\forexdb\\" + fileName;
	            System.out.println(concatFileInfo);
	            try {
	               String sqlldr = "sqlldr userid=SCOTT/TIGER control="+ concatFileInfo +".ctl";
	               Process p = Runtime.getRuntime().exec(sqlldr);
	               BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	               String line = null;
	               while ((line = br.readLine()) != null) {
	                  System.out.println(line);
	               }
	               p.waitFor();
	            } catch (IOException e) {
	               e.printStackTrace();
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	}