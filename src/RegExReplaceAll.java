package org.nlogo.extensions.string;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

public class RegExReplaceAll extends DefaultReporter
{
    // rex-replace-all (occurances of) regex-needle (in) haystack (with) replacement
    
    public Syntax getSyntax()
    {
        return Syntax.reporterSyntax(
            new int[] {Syntax.StringType(), Syntax.StringType(), Syntax.StringType()}, Syntax.StringType()
        ) ;
    }

    public Object report(Argument args[], Context context)
        throws ExtensionException, LogoException
    {
        // use typesafe helper method from
        // org.nlogo.api.Argument to access argument

        String regexNeedle = args[0].getString() ;
        String hayStack = args[1].getString() ;
        String replacement = args[2].getString() ;

        return args[1].getString().replaceAll(args[0].getString(), args[2].getString() ) ;

    }
}
