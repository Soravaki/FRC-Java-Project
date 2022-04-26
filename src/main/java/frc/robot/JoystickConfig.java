// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeMotorCommand;

/** Add your docs here. */
public class JoystickConfig {

    private Joystick primaryJoystick;
    private Joystick secondaryJoystick;

    public JoystickConfig(){
        loadPrimaryJoystick();
        loadSecondaryJoystick();   
    }

    public void loadPrimaryJoystick(){
        primaryJoystick = new Joystick(Constants.DRIVER_CONTROLLER_PRIMARY_PORT);
    }

    public void loadSecondaryJoystick(){
        secondaryJoystick = new Joystick(Constants.DRIVER_CONTROLLER_SECONDARY_PORT);
    }

    public void assignCommands(){
        if (Constants.MODULES_INTAKE_ENABLED){
            JoystickButton a_button = new JoystickButton(secondaryJoystick, Constants.DRIVER_CONTROLLER_SECONDARY_A_BUTTON);
            a_button.whenPressed(new IntakeMotorCommand(1));
        }
    }
    
    public Joystick getPrimaryJoystick(){
        return primaryJoystick;
    }

    public Joystick getSecondaryJoystick(){
        return secondaryJoystick;
    }

}