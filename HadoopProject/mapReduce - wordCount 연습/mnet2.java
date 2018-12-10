package step04_miniProject2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class mnet2 {
	private static BufferedWriter out;

	public static void main(String[] args) {
		Document doc = null;
		try {
			out = new BufferedWriter(new FileWriter("mnet20.txt", true));
			doc = Jsoup.connect("http://www.mnet.com/chart/TOP100/").get();
			Elements lists = doc.select("table > tbody > tr");
			
			for (Element list : lists) {
				
				Integer rank = new Integer(list.select("td.MMLItemRank span").text().replaceAll("À§", ""));
				String title = list.select("td.MMLItemTitle a.MMLI_Song").text();
				String artist = list.select("td.MMLItemTitle a.MMLIInfo_Artist").text();
				String album = list.select("td.MMLItemTitle a.MMLIInfo_Album").text();
				
				Object[] mnetRankList = new Object[4];
				mnetRankList[0] = rank;
				mnetRankList[1] = title;
				mnetRankList[2] = artist;
				mnetRankList[3] = album;
				
				System.out.println(
						mnetRankList[0] + "," + mnetRankList[1] + "," + mnetRankList[2] + "," + mnetRankList[3] + "\n");
				out.write(
						mnetRankList[0] + "," + mnetRankList[1] + "," + mnetRankList[2] + "," + mnetRankList[3] + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}