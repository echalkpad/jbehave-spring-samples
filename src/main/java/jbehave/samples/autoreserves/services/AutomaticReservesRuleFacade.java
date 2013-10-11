package jbehave.samples.autoreserves.services;

import java.math.BigDecimal;
import java.util.List;

import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRule;
import jbehave.samples.autoreserves.AutomaticReservesRuleResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Facade responsible for automatic reserves calculation.
 */
@Service
public class AutomaticReservesRuleFacade {

	@Autowired
	private AutomaticReservesRuleProvider automaticReservesRuleProvider;
	
	@Autowired
	private AutomaticReservesRuleResolver automaticReservesRulesResolver;
	
	/**
	 * Calculates reserves depending on {@link AutomaticReservesContext}.
	 * 
	 * @param reservesContext Automatic reserves context
	 * @return Result with calculated reserves values
	 */
	public AutomaticReservesRuleResult calculateReserves(AutomaticReservesContext reservesContext) {
		List<AutomaticReservesRule> rules =  automaticReservesRuleProvider.provideRules();
		AutomaticReservesRule rule = automaticReservesRulesResolver.findAppropriateRule(rules, reservesContext);
		
		if (rule != null) {
			return rule.getResult();
		}
		AutomaticReservesRuleResult result = new AutomaticReservesRuleResult(new BigDecimal("0.0"), new BigDecimal("0.0"));
		result.setCode("-1");
		return result;
	}
}
