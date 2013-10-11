package jbehave.samples.autoreserves;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;
import java.util.List;

import jbehave.samples.domain.Severity;


import com.google.common.collect.Lists;

public class AutomaticReservesRule {
		
	/**
	 * Unique code of rule. Not optional, used to identify the rule.
	 */
	private String code;
	
	private List<Severity> severities = Lists.newArrayList();
	
	private List<String> causesOfLosses = Lists.newArrayList();
	
	private Boolean totalLossInd;
	
	private List<String> coverages = Lists.newArrayList();
	
	private AutomaticReservesRuleResult result;

	public AutomaticReservesRule() {
		super();
	}
	
	public AutomaticReservesRule(String code) {
		super();
		this.code = code;
	}
	
	public AutomaticReservesRule withNoneSeverity() {		
		setSeverities(null);
		return this;
	}
	
	public AutomaticReservesRule withSeverities(Severity ... severities) {
		if (severities == null) {
			setSeverities(null);
			return this;
		}
		setSeverities(Lists.newArrayList(severities));
		return this;
	}
	
	public AutomaticReservesRule withCausesOfLosses(String ... causesOfLosses) {
		setCausesOfLosses(Lists.newArrayList(causesOfLosses));
		return this;
	}
	
	public AutomaticReservesRule withCausesOfLosses(List<String> causesOfLosses) {
		setCausesOfLosses(causesOfLosses);
		return this;
	}
	
	public AutomaticReservesRule withCoverages(List<String> coverages) {
		setCoverages(coverages);
		return this;
	}
	
	public AutomaticReservesRule withCoverages(String ... coverages) {
		setCoverages(Lists.newArrayList(coverages));
		return this;
	}
	
	public AutomaticReservesRule withResult(double indemnityReserve, double expenseReserve) {
		setResult(new AutomaticReservesRuleResult(valueOf(indemnityReserve), valueOf(expenseReserve)));
		getResult().setCode(code);
		return this;
	}
	
	public AutomaticReservesRule withTotalLoss(Boolean totalLossInd) {
		setTotalLossInd(totalLossInd);
		return this;
	}
	
	public List<Severity> getSeverities() {
		return severities;
	}

	public void setSeverities(List<Severity> severities) {
		this.severities = severities;
	}

	public List<String> getCausesOfLosses() {
		return causesOfLosses;
	}

	public void setCausesOfLosses(List<String> causesOfLosses) {
		this.causesOfLosses = causesOfLosses;
	}

	public Boolean getTotalLossInd() {
		return totalLossInd;
	}

	public void setTotalLossInd(Boolean totalLossInd) {
		this.totalLossInd = totalLossInd;
	}

	public List<String> getCoverages() {
		return coverages;
	}

	public void setCoverages(List<String> coverages) {
		this.coverages = coverages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AutomaticReservesRuleResult getResult() {
		return result;
	}

	public void setResult(AutomaticReservesRuleResult result) {
		this.result = result;
	}
}
