// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/** Add your docs here. */
public class DriveTrain{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Initializing talon variables, three on the left and three on the right
    WPI_TalonSRX leftFrontTalon, leftMiddleTalon, leftBackTalon
    rightFrontTalon, rightMiddleTalon, rightBackTalon = null;

    // creates a DriveTrain
    public DriveTrain(){
    // initializes a new talon, leftFrontTalon, in a new piece of memory and states it is on port 0 of the roboRIO.


    }
}
