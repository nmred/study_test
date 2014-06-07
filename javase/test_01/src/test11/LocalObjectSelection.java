package test11;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class LocalObjectSelection implements Transferable
{
	private Object object;
	public LocalObjectSelection(Object obj)
	{
		this.object = obj;
	}
	
	public DataFlavor[] getTransferDataFlavors()
	{
		DataFlavor[] flavors = new DataFlavor[2];
		Class clazz =  object.getClass();
		String mimeType = "application/x-java-jvm-local-objectref;" + "class=" + clazz.getName();
		System.out.println(mimeType);
		try {
			flavors[0] = new DataFlavor(mimeType);
			flavors[1] = DataFlavor.stringFlavor;
			return flavors;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			//System.out.println(mimeType);
			e.printStackTrace();
			return null;
		}
	}
	
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
	{
		if (!isDataFlavorSupported(flavor)) {
			throw new UnsupportedFlavorException(flavor);
		}
		if (flavor.equals(DataFlavor.stringFlavor)) {
			return object.toString();
		}
		
		return object;
	}
	
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavor.equals(DataFlavor.stringFlavor) || flavor.getPrimaryType().equals("application")
				&& flavor.getSubType().equals("x-java-jvm-local-objectref")
				&& flavor.getRepresentationClass().isAssignableFrom(object.getClass());
	}
}
