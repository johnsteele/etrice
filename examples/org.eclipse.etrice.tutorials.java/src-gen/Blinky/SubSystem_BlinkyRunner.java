/**
 * @author generated by eTrice
 *
 * this class contains the main function running component SubSystem_Blinky
 * it instantiates SubSystem_Blinky and starts and ends the lifecycle
 */

package Blinky;

import org.eclipse.etrice.runtime.java.modelbase.SubSystemRunnerBase;

class SubSystem_BlinkyRunner extends SubSystemRunnerBase {

	/**
     * main function
     * creates the main component and starts and stops the lifecycle
     */
	public static void main(String[] args) {
		// instantiate the main component
		SubSystem_Blinky main_component = new SubSystem_Blinky("SubSystem_Blinky");
		
		run(main_component, args);
	}
};