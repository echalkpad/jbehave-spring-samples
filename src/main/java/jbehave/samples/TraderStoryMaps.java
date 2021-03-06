package jbehave.samples;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;

public class TraderStoryMaps extends JUnitStoryMaps {
    
    public TraderStoryMaps() {
        configuredEmbedder().useMetaFilters(metaFilters());
    }
 
    @Override
    public Configuration configuration() {
    	Class<? extends Embeddable> embeddableClass = this.getClass();
        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd"))
        	,     new ExamplesTableConverter(examplesTableFactory)
        )
                ;
        return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryParser(new RegexStoryParser(examplesTableFactory)) 
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCrossReference(new CrossReference())
            	.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(CONSOLE, TXT, HTML, XML)
//                .withViewResources(new FreemarkerViewGenerator().())
            		)
            .useParameterConverters(parameterConverters);
    }
 
    @Override
    protected List<String> metaFilters() {
    	List<String> metaFilters = new ArrayList();
        metaFilters.add("+author *");
        metaFilters.add("theme *");
        metaFilters.add("-skip");
        return metaFilters;
    }
 
    @Override
    protected List<String> storyPaths() {
    	return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");                 
    }
         
}