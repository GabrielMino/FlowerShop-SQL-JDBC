package view.method;

import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.JDialog;
import javax.swing.JOptionPane;

//methods to show JOptionPane
public class Method {
	
	
	
	public static String getCharacEnum(Class<? extends Enum<?>> e, String producto, String caracteristica) {
		//pop up en primer termino
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		
	    //genero arr del enum
		String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
		//
		String result = (String) JOptionPane.showInputDialog(dialog, "Please select the " +caracteristica+ " of the "+producto, null, JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
	    
	    return result;
	}
	
	public static Double getCharacDouble(String producto,String caracteristica) {
	
		//pop up en primer termino
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		
		boolean condition = true;
		//enter tree height
		double charac = 0;
		do {
			try {charac = Double.parseDouble(JOptionPane.showInputDialog(dialog,"Please enter the "+caracteristica+" of the "+producto));
				condition = false;}
			catch(NumberFormatException e) {
				System.out.println("The "+ caracteristica +" introduced is not correct");}
		}while(condition);
		return charac;
	}
	
	public static Integer selectId(ArrayList<Integer> idList,String producto) {
		//
		// Convert ArrayList to Array
        Integer [] arr = idList.toArray(new Integer[idList.size()]);
		//pop up en primer termino
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		if(idList.size()>0) {
		int id =(int) JOptionPane.showInputDialog(dialog, "Please select the id of the "+producto+".", null, JOptionPane.QUESTION_MESSAGE, null, arr,arr[0]);
		return id;
		
		} else {
			JOptionPane.showMessageDialog(null, "There isn´t any "+ producto+ " in stock", "Hey!", JOptionPane.ERROR_MESSAGE);
		return null;
		}
		
		}

		public static String getCategory(Class<? extends Enum<?>> e) {
		//pop up en primer termino
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		
	    //genero arr del enum
		String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
		//
		String result = (String) JOptionPane.showInputDialog(dialog, "Please select the category", null, JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
	    
	    return result;
	}


}
	

