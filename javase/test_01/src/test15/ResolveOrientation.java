package test15;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class ResolveOrientation 
	implements Serializable
{
	public static final ResolveOrientation HORIZONTAL = new ResolveOrientation(1);
	public static final ResolveOrientation VERTICAL   = new ResolveOrientation(2);
	private int value;
	
	private ResolveOrientation(int value)
	{
		this.value = value;
	}
	
	private Object readResolve() throws ObjectStreamException
	{
		if (value == 1) {
			return HORIZONTAL;
		} else if (value == 2) {
			return VERTICAL;
		}
		
		return null;
	}
}
