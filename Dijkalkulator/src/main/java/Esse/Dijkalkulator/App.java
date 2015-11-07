package esse.Dijkalkulator;

/**
 * Hello world!
 *
 */
public class App 
{
	static GUIForDijkalkulator oGUIForDijkalkulator = new GUIForDijkalkulator();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       oGUIForDijkalkulator.setVisible(true);
    }
	public static GUIForDijkalkulator getoGUIForDijkalkulator() {
		return oGUIForDijkalkulator;
	}
	public static void setoGUIForDijkalkulator(GUIForDijkalkulator oGUIForDijkalkulator) {
		App.oGUIForDijkalkulator = oGUIForDijkalkulator;
	}
    
    
}
