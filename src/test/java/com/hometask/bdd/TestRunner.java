package com.hometask.bdd;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\Features", glue = {"com.hometask.bdd.stepdefinition"}, dryRun = false, monochrome = true)
public class TestRunner {

}
