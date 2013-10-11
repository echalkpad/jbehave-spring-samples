package jbehave.samples.stories.rule;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.text.SimpleDateFormat;

import jbehave.samples.steps.rule.RuleComplianceSteps;


import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.junit.runner.RunWith;


import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/**
 * Runs {@link RuleComplianceSteps}.
 */
@RunWith(JUnitReportingRunner.class)
public class RuleComplianceStorySimple extends JUnitStory {
   
	public RuleComplianceStorySimple() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true).useStoryTimeoutInSecs(60);       
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(
        		new DateConverter(new SimpleDateFormat("yyyy-MM-dd")), 
        		new ExamplesTableConverter(examplesTableFactory),
        		new ParameterConverters.EnumConverter()
        )
                ;
        return new MostUsefulConfiguration()
//        	.doDryRun(true)
//        	.useFailureStrategy(new SilentlyAbsorbingFailure())
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryParser(new RegexStoryParser(examplesTableFactory))            
            .useStoryReporterBuilder(new StoryReporterBuilder()
//                .withCrossReference(new CrossReference())
            	.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(CONSOLE, TXT, XML, HTML)
            )
//            .useStepPatternParser(new RegexPrefixCapturingPatternParser("%"))
            .useParameterConverters(parameterConverters);
    }
	
	@Override
    public InjectableStepsFactory stepsFactory() {
    	return new InstanceStepsFactory(configuration(), new RuleComplianceSteps());
    }
        
}