package org.nlogo.extensions.string;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

public class AsciiCode extends DefaultReporter {
	// take a character and return the ascii code
	
	public Syntax getSyntax()
	{
		return Syntax.reportSyntax(
				return Syntax.reporterSyntax(
					new int[]{ Syntax.StringType }, Syntax.NumberType()
				);
	}


	public Object report(Argument args[], Context context)
		throws ExtensionException, LogoException
	{
		// use typesafe helper method from
		// org.nlogo.api.Argument to access argument
		char c = args[0].getString().charAt(0);
		int ascii = (int) c;
		return ascii;
	}
}
