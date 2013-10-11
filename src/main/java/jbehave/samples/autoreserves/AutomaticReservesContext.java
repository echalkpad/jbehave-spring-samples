package jbehave.samples.autoreserves;

import jbehave.samples.domain.Severity;

public class AutomaticReservesContext {
	
	private Severity severity;

	private String causeOfLoss;
	
	private String coverageCd;
	
	private Boolean totalLossInd;

	public AutomaticReservesContext(Severity severity, String causeOfLoss, String coverageCd) {
		super();
		this.severity = severity;
		this.causeOfLoss = causeOfLoss;
		this.coverageCd = coverageCd;
	}
	
	public AutomaticReservesContext(Boolean totalLoss, String causeOfLoss, String coverageCd) {
		super();
		this.totalLossInd = totalLoss;
		this.causeOfLoss = causeOfLoss;
		this.coverageCd = coverageCd;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getCauseOfLoss() {
		return causeOfLoss;
	}

	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	public String getCoverageCd() {
		return coverageCd;
	}

	public void setCoverageCd(String coverageCd) {
		this.coverageCd = coverageCd;
	}

	public Boolean getTotalLossInd() {
		return totalLossInd;
	}

	public void setTotalLossInd(Boolean totalLossInd) {
		this.totalLossInd = totalLossInd;
	}

	
}
