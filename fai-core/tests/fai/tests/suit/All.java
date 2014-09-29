package fai.tests.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fai.tests.command.CommandTests;
import fai.tests.conn.ConnectionTest;
import fai.tests.login.LoginTests;
import fai.tests.pagamento.PagamentoTests;

@RunWith(Suite.class)
@SuiteClasses({ PagamentoTests.class, LoginTests.class, ConnectionTest.class })
public class All {

}
