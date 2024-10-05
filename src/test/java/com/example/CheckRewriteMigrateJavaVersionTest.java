package com.example;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

class CheckRewriteMigrateJavaVersionTest implements RewriteTest {
	@Test
	void testPrintRewriteVersion() {
		rewriteRun(spec -> spec.recipe(new CheckRewriteMigrateJavaVersion()));
	}
}