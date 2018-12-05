package forex.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import forex.model.dto.forexDTO;
import forex.model.util.DBUtil;

public class forexDAO {

	// insert
	/*public static void ForexDrop() {
	      initForTable();
	   }
	   
	   public static void ForexLoad() {
	      initForTable();
	      initLoad("FOREX");
	   }
	   public static void ForexCurLoad() {
	      insLoad("INSFOREX");
	   }
	   */
	   
	// ? 모든 환율 정보 검색
	public static ArrayList<forexDTO> getAllForex() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<forexDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from forex");
			rset = pstmt.executeQuery();

			list = new ArrayList<forexDTO>();
			while (rset.next()) {
				list.add(new forexDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8), rset.getDouble(9),
						0));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	//? 모든 환율 정보중 최근 10개
	public static ArrayList<forexDTO> getForex() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<forexDTO> flist = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from forex where rownum <=10 order by time desc");
			rset = pstmt.executeQuery();

			flist = new ArrayList<forexDTO>();
			while (rset.next()) {
				flist.add(new forexDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8), rset.getDouble(9), 0 ));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return flist;
	}

	// ?rownum으로 delete 
	public static boolean deleteForex(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from forex where rownum = ?");

			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() != 0) {
				return true;
			}

		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}
	
	
	/*public static boolean deleteforex(int rownum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from forex where rownum = ?");
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
