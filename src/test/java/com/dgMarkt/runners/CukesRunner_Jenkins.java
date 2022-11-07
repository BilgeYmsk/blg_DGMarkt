package com.dgMarkt.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/dgMarkt/stepDefs",
        dryRun = false,
        tags = "@DGMARA-81"

)

public class CukesRunner_Jenkins {
}
