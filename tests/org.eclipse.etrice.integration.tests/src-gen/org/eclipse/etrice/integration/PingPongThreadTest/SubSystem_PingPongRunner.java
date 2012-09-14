/**
 * @author generated by eTrice
 *
 * this class contains the main function running component SubSystem_PingPong
 * it instantiates SubSystem_PingPong and starts and ends the lifecycle
 */

package org.eclipse.etrice.integration.PingPongThreadTest;

import org.eclipse.etrice.runtime.java.modelbase.SubSystemRunnerBase;

class SubSystem_PingPongRunner extends SubSystemRunnerBase {

	/**
     * main function
     * creates the main component and starts and stops the lifecycle
     */
	public static void main(String[] args) {
		// instantiate the main component
		SubSystem_PingPong main_component = new SubSystem_PingPong("SubSystem_PingPong");
		
		run(main_component, args);
	}
};
