package jbehave.samples.autoreserves.services;

import static jbehave.samples.domain.CauseOfLoss.AUTOINCIDENT;
import static jbehave.samples.domain.CauseOfLoss.THEFT;
import static jbehave.samples.domain.CauseOfLoss.VANDALISM;
import static jbehave.samples.domain.CoverageCodes.MPD;
import static jbehave.samples.domain.CoverageCodes.UMPD;

import java.util.List;

import jbehave.samples.autoreserves.AutomaticReservesRule;
import jbehave.samples.domain.Severity;


import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * Automatic reserves rules provider.
 * 
 */
@Service
public class AutomaticReservesRuleProvider {

	/**
	 * Provides list of rules used for automatic reserves calculation.
	 * 
	 * @return List of rules
	 */
	public List<AutomaticReservesRule> provideRules() {
		List<AutomaticReservesRule> rules = Lists.newArrayList();
		
		rules.add(new AutomaticReservesRule("1").withCausesOfLosses(AUTOINCIDENT, VANDALISM)
				.withCoverages(UMPD).withTotalLoss(true)
//				.withNoneSeverity()
				.withResult(12000, 1000));
		
		rules.add(new AutomaticReservesRule("2").withCausesOfLosses(AUTOINCIDENT, VANDALISM)
				.withCoverages(UMPD).withSeverities(Severity.MAJOR).withTotalLoss(false)
				.withResult(12000, 1000));
		rules.add(new AutomaticReservesRule("3").withCausesOfLosses(AUTOINCIDENT, VANDALISM)
				.withCoverages(UMPD).withSeverities(Severity.MODERATE).withTotalLoss(false)
				.withResult(4000, 500));
		rules.add(new AutomaticReservesRule("4").withCausesOfLosses(AUTOINCIDENT, VANDALISM)
				.withCoverages(UMPD).withSeverities(Severity.MINOR).withTotalLoss(false)
				.withResult(1000, 200));
		
		rules.add(new AutomaticReservesRule("5").withCausesOfLosses(THEFT).withResult(12000, 1500));
		
		rules.add(new AutomaticReservesRule("6").withCausesOfLosses(AUTOINCIDENT)
				.withCoverages(MPD).withSeverities(Severity.MAJOR).withResult(100000, 5000));
		rules.add(new AutomaticReservesRule("7").withCausesOfLosses(AUTOINCIDENT)
				.withCoverages(MPD).withSeverities(Severity.MODERATE).withResult(30000, 2000));
		rules.add(new AutomaticReservesRule("8").withCausesOfLosses(AUTOINCIDENT)
				.withCoverages(MPD).withSeverities(Severity.MINOR).withResult(10000, 500));
		
		return rules;
	}
}
