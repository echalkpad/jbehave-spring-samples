package jbehave.samples.autoreserves.services;


import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRule;

import com.google.common.base.Predicate;

/**
 * Predicate used to determine if {@link AutomaticReservesRule}
 * conditions meet {@link AutomaticReservesContext}
 */
public class AutomaticReservesRulePredicate implements Predicate<AutomaticReservesRule> {

	private AutomaticReservesContext reservesContext;

	/**
	 * Predicate constructor with {@link AutomaticReservesContext} parameter.
	 * 
	 * @param reservesContext Auto reserves context
	 */
	public AutomaticReservesRulePredicate(AutomaticReservesContext reservesContext) {
		this.reservesContext = reservesContext;
	}
	
	public AutomaticReservesContext getReservesContext() {
		return reservesContext;
	}

	public void setReservesContext(AutomaticReservesContext reservesContext) {
		this.reservesContext = reservesContext;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean apply(AutomaticReservesRule rule) {
		if (rule.getTotalLossInd() != null
				&& !rule.getTotalLossInd().equals(reservesContext.getTotalLossInd())) {
			return false;
		}
		
		if (rule.getSeverities() == null) {
			if (reservesContext.getSeverity() != null) {
				return false;
			}
		} else
		
		if (rule.getSeverities().size() > 0
				&& !rule.getSeverities().contains(reservesContext.getSeverity())) {
			return false;
		}
		
		if (rule.getCausesOfLosses().size() > 0
				&& !rule.getCausesOfLosses().contains(reservesContext.getCauseOfLoss())) {
			return false;
		}
	
		if (rule.getCoverages().size() > 0
				&& !rule.getCoverages().contains(reservesContext.getCoverageCd())) {
			return false;
		}	
		
		return true;
	}
}
