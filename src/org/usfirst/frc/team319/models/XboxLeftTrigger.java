/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc.team319.models;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author mwtidd
 */
public class XboxLeftTrigger extends Button{
    private final Joystick joystick;

    public XboxLeftTrigger(Joystick joystick){
        this.joystick = joystick;

    }

    public boolean get() {
        return joystick.getRawAxis(2) > .25;
    }
}
