package step04_miniProject2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class movie2 {
	private static BufferedWriter out;

	public static void main(String[] args) {
		Document doc = null;
		try {
			out = new BufferedWriter(new FileWriter("movie22.txt", true));
			doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
			Elements lists = doc.select("li > dl");
			int index = 0;
			for (Element list : lists) {
				index += 1;
				String title = list.select("dt.tit a").text();
				Float rate = new Float(list.select("a span.num").text());
				String genre = list.select("dd:nth-child(3) > dl > dd:nth-child(2) > span.link_txt > a:nth-child(n)")
						.text().replace(" ", "#").replace("/", "#");
				String director = list.select("dd:nth-child(3) > dl > dd:nth-child(4) > span > a").text();
				String actor = list.select("dd:nth-child(3) > dl > dd:nth-child(6) > span > a:nth-child(n)").text()
						.replaceAll(" ", "#");
				Object[] movieCurrentList = new Object[6];
				movieCurrentList[0] = index;
				movieCurrentList[1] = title;
				movieCurrentList[2] = rate;
				movieCurrentList[3] = genre;
				movieCurrentList[4] = director;
				movieCurrentList[5] = actor;

				System.out.println(movieCurrentList[0] + "|" + movieCurrentList[1] + "|" + movieCurrentList[2] + "|"
						+ movieCurrentList[3] + "|" + movieCurrentList[4] + "|" + movieCurrentList[5] + "\n");
				out.write(movieCurrentList[0] + "|" + movieCurrentList[1] + "|" + movieCurrentList[2] + "|"
						+ movieCurrentList[3] + "|" + movieCurrentList[4] + "|" + movieCurrentList[5] + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}