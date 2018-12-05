package forex.model.dto;

public class USDKRWDTO {
	private double now;
	private double changes;
	private double changespercent;
	private double daymin;
	private double daymax;
	private double yearmin;
	private double yearmax;

	public USDKRWDTO() {
	}

	public USDKRWDTO(String time, double now, double changes, double changespercent, double daymin, double daymax,
			double yearmin, double yearmax) {
		this.now = now;
		this.changes = changes;
		this.changespercent = changespercent;
		this.daymin = daymin;
		this.daymax = daymax;
		this.yearmin = yearmin;
		this.yearmax = yearmax;
	}

	public double getNow() {
		return now;
	}

	public void setNow(double now) {
		this.now = now;
	}

	public double getChanges() {
		return changes;
	}

	public void setChanges(double changes) {
		this.changes = changes;
	}

	public double getChangespercent() {
		return changespercent;
	}

	public void setChangespercent(double changespercent) {
		this.changespercent = changespercent;
	}

	public double getDaymin() {
		return daymin;
	}

	public void setDaymin(double daymin) {
		this.daymin = daymin;
	}

	public double getDaymax() {
		return daymax;
	}

	public void setDaymax(double daymax) {
		this.daymax = daymax;
	}

	public double getYearmin() {
		return yearmin;
	}

	public void setYearmin(double yearmin) {
		this.yearmin = yearmin;
	}

	public double getYearmax() {
		return yearmax;
	}

	public void setYearmax(double yearmax) {
		this.yearmax = yearmax;
	}

	@Override
	public String toString() {
		return "USDKRWDTO [now=" + now + ", changes=" + changes + ", changespercent=" + changespercent + ", daymin="
				+ daymin + ", daymax=" + daymax + ", yearmin=" + yearmin + ", yearmax=" + yearmax + "]";
	}

}
