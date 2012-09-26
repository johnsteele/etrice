/**
 * @author generated by eTrice
 *
 * this class contains the main function running component SubSys_PedLights
 * it instantiates SubSys_PedLights and starts and ends the lifecycle
 */

package PedLightsController;

import org.eclipse.etrice.runtime.java.modelbase.SubSystemRunnerBase;

class SubSys_PedLightsRunner extends SubSystemRunnerBase {

	static SubSys_PedLights main_component = new SubSys_PedLights(null, "SubSys_PedLights");

	/**
     * main function
     * creates component and starts and stops the lifecycle
     */
	public static void main(String[] args) {

		System.out.println("***   T H E   B E G I N   ***");
		
		main_component.init(); // lifecycle init
		main_component.start(); // lifecycle start

		// application runs until quit 
		waitForQuit();
		
		// end the lifecycle
		main_component.stop(); // lifecycle stop
		main_component.destroy(); // lifecycle destroy

		System.out.println("***   T H E   E N D   ***");
	}
};