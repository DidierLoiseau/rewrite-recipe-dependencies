package com.example;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.openrewrite.Recipe;
import org.openrewrite.Validated;

import static org.openrewrite.NlsRewrite.Description;
import static org.openrewrite.NlsRewrite.DisplayName;

@Value
@EqualsAndHashCode(callSuper = false)
public class CheckRewriteMigrateJavaVersion extends Recipe {
	@Override
	public @DisplayName String getDisplayName() {
		return "Print Rewrite Version";
	}

	@Override
	public @Description String getDescription() {
		return "Print Rewrite version.";
	}

	@Override
	public Validated<Object> validate() {
		try {
			Package p = getClass().getClassLoader().loadClass("org.openrewrite.java.migrate.lang.UseTextBlocks").getPackage();
			System.out.printf("Title: %s%n  Version: %s%n",
					p.getImplementationTitle(),
					p.getImplementationVersion());
			String expectedVersion = "2.26.1";
			return Validated.test("rewrite-spring.version", "Should be " + expectedVersion, p.getImplementationVersion(), expectedVersion::equals);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
