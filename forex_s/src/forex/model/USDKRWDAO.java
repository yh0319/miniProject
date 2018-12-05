package forex.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import forex.model.dto.USDKRWDTO;
import forex.model.util.DBUtil;

public class USDKRWDAO {

	// insert
		/*public static void USDKRWDrop() {
	      initUSDKRWTable();
	   }
	   
	   public static void USDKRWLoad() {
	      initUSDKRWTable();
	      initLoad("USDKRW");
	   }
	   public static void USDKRWCurLoad() {
	      insLoad("USDKRW");
	   }*/
	
	// ?모든 정보 검색
	public static ArrayList<USDKRWDTO> getAllUSDKRW() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<USDKRWDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from USDKRW");
			rset = pstmt.executeQuery();

			list = new ArrayList<USDKRWDTO>();
			while (rset.next()) {
				list.add(new USDKRWDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), 0));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// ? USDKRW 에서 rownum으로 now값, daymin, daymax 검색하기
	public static USDKRWDTO getUSDKRW(int rownum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		USDKRWDTO usdkrw = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select now, daymin, daymax from USDKRW where rownum = ?");
			pstmt.setInt(1, rownum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				usdkrw = new USDKRWDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), 0);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usdkrw;
	}

	// ?row num으로 delete
	public static boolean deleteUsdKrw(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from USDKRW where rownum = ?");

			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() != 0) {
				return true;
			}

		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}
	
	/*
	public static boolean deleteUsdkrw(int rownum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from USDKRD where rownum = ?");
			pstmt.setInt(1, rownum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}*/

}
