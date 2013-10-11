package jbehave.samples.stories.reserves;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.text.SimpleDateFormat;

import jbehave.samples.steps.converter.EnumNullConverter;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.jbehave.core.steps.SilentStepMonitor;

/**
 * Specifies the Embedder for the Trader example, providing the
 * Configuration and the CandidateSteps, using classpath story loading.
 */
public class CoreEmbedder extends Embedder {

    @Override
	public Configuration configuration() {
		Class<? extends CoreEmbedder> embeddableClass = this.getClass();
        
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(
        		new DateConverter(new SimpleDateFormat("yyyy-MM-dd")), 
        		new ExamplesTableConverter(examplesTableFactory),
//        		new ParameterConverters.EnumConverter(),
        		new EnumNullConverter()
        )
                ;
        return new MostUsefulConfiguration()
//        	.doDryRun(true)
//        	.useFailureStrategy(new SilentlyAbsorbingFailure())
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryParser(new RegexStoryParser(examplesTableFactory))            
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCrossReference(new CrossReference())
            	.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(CONSOLE, TXT, XML, HTML)
            )
//            .useStepPatternParser(new RegexPrefixCapturingPatternParser("%"))
            .useParameterConverters(parameterConverters);								
	}

}