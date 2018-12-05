package forex.model.dto;

public class forexDTO {
	private String time;
	private double USDKRW;
	private double KRWEUR;
	private double EURCNY;
	private double KRWJPY;
	private double KRWCNY;
	private double ERUKRW;
	private double GBPEUR;
	private double JPYKRW;
	private double GBPUSD;

	public forexDTO() {
	}

	public forexDTO(String time, double USDKRW, double KRWEUR, double EURCNY, double KRWJPY, double KRWCNY,
			double ERUKRW, double GBPEUR, double JPYKRW, double GBPUSD) {
		super();
		this.time = time;
		this.USDKRW = USDKRW;
		this.KRWEUR = KRWEUR;
		this.EURCNY = EURCNY;
		this.KRWJPY = KRWJPY;
		this.KRWCNY = KRWCNY;
		this.ERUKRW = ERUKRW;
		this.GBPEUR = GBPEUR;
		this.JPYKRW = JPYKRW;
		this.GBPUSD = GBPUSD;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getUSDKRW() {
		return USDKRW;
	}

	public void setUSDKRW(double USDKRW) {
		this.USDKRW = USDKRW;
	}

	public double getKRWEUR() {
		return KRWEUR;
	}

	public void setKRWEUR(double KRWEUR) {
		this.KRWEUR = KRWEUR;
	}

	public double getEURCNY() {
		return EURCNY;
	}

	public void setEURCNY(double EURCNY) {
		this.EURCNY = EURCNY;
	}

	public double getKRWJPY() {
		return KRWJPY;
	}

	public void setKRWJPY(double KRWJPY) {
		this.KRWJPY = KRWJPY;
	}

	public double getKRWCNY() {
		return KRWCNY;
	}

	public void setKRWCNY(double KRWCNY) {
		this.KRWCNY = KRWCNY;
	}

	public double getERUKRW() {
		return ERUKRW;
	}

	public void setERUKRW(double ERUKRW) {
		this.ERUKRW = ERUKRW;
	}

	public double getGBPEUR() {
		return GBPEUR;
	}

	public void setGBPEUR(double GBPEUR) {
		this.GBPEUR = GBPEUR;
	}

	public double getJPYKRW() {
		return JPYKRW;
	}

	public void setJPYKRW(double JPYKRW) {
		this.JPYKRW = JPYKRW;
	}

	public double getGBPUSD() {
		return GBPUSD;
	}

	public void setGBPUSD(double GBPUSD) {
		this.GBPUSD = GBPUSD;
	}

	@Override
	public String toString() {
		return "forexDTO " + "[" + "time=" + time + "" + ", USDKRW=" + USDKRW + ", KRWEUR=" + KRWEUR
				+ ", EURCNY=" + EURCNY + ", KRWJPY=" + KRWJPY + ", KRWCNY=" + KRWCNY + ", ERUKRW=" + ERUKRW
				+ ", GBPEUR=" + GBPEUR + ", JPYKRW=" + JPYKRW + ", GBPUSD=" + GBPUSD + "]";
	}

}
