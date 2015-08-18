package org.nlogo.extensions.string;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

public class FromAscii extends DefaultReporter 
{
	// take an integer ascii code and return the letter
	
	public Syntax getSyntax()
	{
		return Syntax.reporterSyntax(
				new int[]{ Syntax.NumberType() }, Syntax.StringType()
			);
	}

	public Object report(Argument args[], Context context)
		throws ExtensionException, LogoException
	{
		// use typesafe helper method from
		// org.nlogo.api.Argument ot access argument
		int i;
		try {
			i = args[0].getIntValue();
		}
		catch(LogoException e) {
			throw new ExtensionException(e.getMessage());
		}
		
		if (i < 0 || i > 128) {
			return "";
		} else {
			char c = (char) i;
			String s = new Character(c).toString();
			return s;
		}
	}
}
