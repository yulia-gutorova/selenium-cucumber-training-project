package cucumber_steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = {"cucumber_steps"},
        tags = "@AjaxForm",
        plugin = {"pretty", "summary"},
        publish = true)
public class TagTestRunner {

}
