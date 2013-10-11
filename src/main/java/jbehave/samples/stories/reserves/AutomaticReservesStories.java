package jbehave.samples.stories.reserves;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import jbehave.samples.steps.reserves.AutomaticReservesSteps;


import org.jbehave.core.Embeddable;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/**
 * 
 */
@RunWith(JUnitReportingRunner.class)
public class AutomaticReservesStories extends GenericUserStories {
    
	 @Override
	 public InjectableStepsFactory stepsFactory() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		 return new SpringStepsFactory(configuration(), context);
	 }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/auto_reserves*.story", "**/excluded*.story");                
    }
        
}