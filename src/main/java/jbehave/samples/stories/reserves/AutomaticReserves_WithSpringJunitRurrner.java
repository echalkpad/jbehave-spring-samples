package jbehave.samples.stories.reserves;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/sample-beans.xml"})
public class AutomaticReserves_WithSpringJunitRurrner {

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
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/auto_reserves_examples.story", "**/excluded*.story"); 
        embedder.runStoriesAsPaths(storyPaths);
    }	
   
	
}
