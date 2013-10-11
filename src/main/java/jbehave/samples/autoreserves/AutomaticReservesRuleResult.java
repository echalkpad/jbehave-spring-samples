package jbehave.samples.autoreserves;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO representing auto reserves rule result.
 * 
 */
public class AutomaticReservesRuleResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor without fields.
	 */
	public AutomaticReservesRuleResult() {
		super();
	}

	/**
	 * Constructor with parameters. 
	 * 
	 * @param indemnityReserve Set to {@link AutomaticReservesRuleResult#indemnityReserve}
	 * @param expenseReserve Set to {@link AutomaticReservesRuleResult#expenseReserve}
	 */
	public AutomaticReservesRuleResult(BigDecimal indemnityReserve,	BigDecimal expenseReserve) {
		super();
		this.indemnityReserve = indemnityReserve;
		this.expenseReserve = expenseReserve;
	}

	/**
	 * Unique code taken from {@link AutomaticReservesRule}. Used to identify
	 * rule, which returned result.
	 */
	private String code;
	
	/**
	 * Value which should be set automatically to indemnity reserve of {@link ClaimsFeature}.	 
	 */
	private BigDecimal indemnityReserve;
	
	/**
	 * Value which should be set automatically to expense reserve of {@link ClaimsFeature}.
	 */
	private BigDecimal expenseReserve;

	
	public BigDecimal getIndemnityReserve() {
		return indemnityReserve;
	}

	public void setIndemnityReserve(BigDecimal indemnityReserve) {
		this.indemnityReserve = indemnityReserve;
	}

	public BigDecimal getExpenseReserve() {
		return expenseReserve;
	}

	public void setExpenseReserve(BigDecimal expenseReserve) {
		this.expenseReserve = expenseReserve;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "AutomaticReservesRuleResult [code=" + code
				+ ", indemnityReserve=" + indemnityReserve
				+ ", expenseReserve=" + expenseReserve + "]";
	}



}
