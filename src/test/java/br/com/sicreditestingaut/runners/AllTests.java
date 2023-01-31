package br.com.sicreditestingaut.runners;

import br.com.sicreditestingaut.tests.restricoes.tests.GetRestricoesTest;
import br.com.sicreditestingaut.tests.simulacoes.tests.GetSimulacoesTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.sicreditestingaut.suites.AllTests.class)
@Suite.SuiteClasses({
        GetRestricoesTest.class,
        GetSimulacoesTest.class
})
public class AllTests {
}
