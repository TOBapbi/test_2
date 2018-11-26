package Bean;


public class CouBean {
	private int couid;
	private String couname;
	private int coutimes;
	private String couroom;
	private String coutea;

	public int getCouid() {
		return couid;
	}

	public void setCouid(int couid) {
		this.couid = couid;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public int getCoutimes() {
		return coutimes;
	}

	public void setCoutimes(int coutimes) {
		this.coutimes = coutimes;
	}

	public String getCouroom() {
		return couroom;
	}

	public void setCouroom(String couroom) {
		this.couroom = couroom;
	}

	public String getCoutea() {
		return coutea;
	}

	public void setCoutea(String coutea) {
		this.coutea = coutea;
	}
	public CouBean(int couid, String couname, int coutimes, String couroom, String coutea) {
		this.couid = couid;
		this.couname = couname;
		this.coutimes = coutimes;
		this.couroom = couroom;
		this.coutea = coutea;
	}
	public CouBean(String couname, int coutimes, String couroom, String coutea) {
		this.couname = couname;
		this.coutimes = coutimes;
		this.couroom = couroom;
		this.coutea = coutea;
	}

}
