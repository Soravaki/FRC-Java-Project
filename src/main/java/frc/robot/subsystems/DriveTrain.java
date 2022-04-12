// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


/** Add your docs here. */
public class DriveTrain extends SubsystemBase{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.


    
    // Initializing talon variables, three on the left and three on the right
    Talon leftFrontTalon = null;
    Talon leftMiddleTalon = null; 
    Talon leftBackTalon = null;
    Talon rightFrontTalon = null;
    Talon rightMiddleTalon = null;
    Talon rightBackTalon = null;

    MotorControllerGroup leftMotors = null;
    MotorControllerGroup rightMotors = null;

    DifferentialDrive differentialDrive = null;

    // creates a DriveTrain
    public DriveTrain(){
    // initializes a new talons, in a new piece of memory and states it is on port 0 of the roboRIO.
    leftFrontTalon = new Talon(Constants.DRIVETRAIN_LEFT_FRONT_TALON);
    leftMiddleTalon = new Talon(Constants.DRIVETRAIN_LEFT_MIDDLE_TALON);
    leftBackTalon = new Talon (Constants.DRIVETRAIN_LEFT_BACK_TALON);

    rightFrontTalon = new Talon(Constants.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightMiddleTalon = new Talon(Constants.DRIVETRAIN_RIGHT_MIDDLE_TALON);
    rightBackTalon = new Talon(Constants.DRIVETRAIN_RIGHT_BACK_TALON);

    leftMotors = new MotorControllerGroup(leftFrontTalon, leftMiddleTalon, leftBackTalon);
    rightMotors = new MotorControllerGroup(rightFrontTalon, rightMiddleTalon, rightBackTalon);
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed){
        differentialDrive.tankDrive(moveSpeed, rotateSpeed);
    }

    @Override
    public void periodic() {
        
      // This method will be called once per scheduler run
    }

}
