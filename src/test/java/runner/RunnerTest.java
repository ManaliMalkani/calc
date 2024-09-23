package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Uncomment @RunWith if you are using Junit to run Test
// @RunWith(Cucumber.class)

@RunWith(Cucumber.class)
@CucumberOptions(features={".//src/test/java/features/Calculator.feature"}
        ,glue="StepsDef"
        ,dryRun = false
        ,monochrome = true
        ,plugin = {"pretty"}
)

//public class RunTest extends AbstractTestNGCucumberTests{
    public class RunnerTest{
}