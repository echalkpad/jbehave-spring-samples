package jbehave.samples.autoreserves.services;

import java.util.List;

import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRule;

import org.springframework.stereotype.Service;


import com.google.common.collect.Iterables;

/**
 * Automatic reserves rule resolver responsible
 * for finding appropriate rule for {@link AutomaticReservesContext}.
 */
@Service
public class AutomaticReservesRuleResolver {

	/**
	 * Finds rule which is applicable for concrete {@link AutomaticReservesContext}.
	 * For finding rules {@link AutomaticReservesRulePredicate} is used.
	 * Result is returned on first rule which requirement meet context.
	 * 
	 * @param rules List of rules which is used search for applicable rule
	 * @param reservesContext {@link AutomaticReservesContext} with context data
	 * @return Found applicable {@link AutomaticReservesRule}. If rule is not found null is returned.
	 */
	public AutomaticReservesRule findAppropriateRule(List<AutomaticReservesRule> rules,	AutomaticReservesContext reservesContext) {		
		return Iterables.find(rules, new AutomaticReservesRulePredicate(reservesContext), null);
	}

	
	

	
}