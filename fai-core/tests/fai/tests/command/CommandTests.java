package fai.tests.command;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CommandTests.class, ValidadorClienteExistenteTest.class,
		ValidadorCPFTest.class })
public class CommandTests {

}
