package jbehave.samples;

import java.text.SimpleDateFormat;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.springframework.context.ApplicationContext;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;


public class TraderEmbedder extends Embedder {

    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
    }

    @Override
	public Configuration configuration() {
		Class<? extends TraderEmbedder> embedderClass = this.getClass();
		return new MostUsefulConfiguration()
			.useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
			.useStoryReporterBuilder(new StoryReporterBuilder()
        		.withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
        		.withDefaultFormats()
				.withFormats(CONSOLE, TXT, HTML, XML)
				.withCrossReference(new CrossReference()))
            .useParameterConverters(new ParameterConverters()
                	.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")))) // use custom date pattern
            .useStepPatternParser(new RegexPrefixCapturingPatternParser(
							"%")) // use '%' instead of '$' to identify parameters
			.useStepMonitor(new SilentStepMonitor());								
	}

    @Override
    public InjectableStepsFactory stepsFactory() {
    	String path = "lt.dslaveckij.jbehave.samples".replaceAll("\\.", "/");
        ApplicationContext context = new SpringApplicationContextFactory(path+"/my_steps.xml").createApplicationContext();
        return new SpringStepsFactory(configuration(), context);
    }

}