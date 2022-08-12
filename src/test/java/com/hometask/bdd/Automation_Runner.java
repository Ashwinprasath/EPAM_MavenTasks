package com.hometask.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\Features\\Task2.feature", glue = "com.hometask.bdd.stepdefinition", monochrome = true, dryRun = false, tags = "@TC2")
public class Automation_Runner {

}
