package MainModules.AbstractClasses;

import DataPackage.Variable;
import org.json.simple.parser.ParseException;

public abstract class StringProcessingAbs extends Variable {
    public abstract void substringString() throws ParseException;

    public abstract void appendString() throws ParseException;

    public abstract void toLowerCaseString() throws ParseException;

    public abstract void toUpperCaseString() throws ParseException;

    public abstract void replaceString();
}
