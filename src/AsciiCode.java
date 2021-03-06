package org.nlogo.extensions.string;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class AsciiCode extends DefaultReporter {
	// take a character and return the ascii code
	
	static CharsetEncoder asciiEncoder =
		Charset.forName("US-ASCII").newEncoder();

	public Syntax getSyntax()
	{
		return Syntax.reporterSyntax(
				new int[]{ Syntax.StringType() }, Syntax.NumberType()
			);
	}


	public Object report(Argument args[], Context context)
		throws ExtensionException, LogoException
	{
		// use typesafe helper method from
		// org.nlogo.api.Argument to access argument
		char c;
		try {
			c = args[0].getString().charAt(0);
		} catch (LogoException e) {
			throw new ExtensionException(e.getMessage());
		}
		
		if (asciiEncoder.canEncode(c)) {
			return Double.valueOf((int) c);
		} else {
			return Double.valueOf(0);
		}
	}
}
