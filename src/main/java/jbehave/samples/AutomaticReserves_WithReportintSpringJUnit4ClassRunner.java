package jbehave.samples;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

import java.util.List;

import jbehave.samples.stories.reserves.CoreEmbedder;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(ReportintSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/sample-beans.xml"})
@Ignore
public class AutomaticReserves_WithReportintSpringJUnit4ClassRunner {

	@Autowired
    protected ApplicationContext context;

    private CoreEmbedder embedder;

    @Before
    public void setup() {
        embedder = new CoreEmbedder();
        embedder.useConfiguration(embedder.configuration());
        embedder.useCandidateSteps(new SpringStepsFactory(embedder.configuration(), context).createCandidateSteps());
    }

    @Test
    public void runStoriesAsPaths() {
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/auto_reserves.story", "**/excluded*.story"); 
        embedder.runStoriesAsPaths(storyPaths);
    }	
   
	
}
