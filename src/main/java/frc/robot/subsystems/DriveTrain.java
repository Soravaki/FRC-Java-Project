// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;


/** Add your docs here. */
public class DriveTrain extends SubsystemBase{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Initializing talon variables, three on the left and three on the right
    CANSparkMax leftFrontTalon = null;
    CANSparkMax leftMiddleTalon = null; 
    CANSparkMax leftBackTalon = null;
    CANSparkMax rightFrontTalon = null;
    CANSparkMax rightMiddleTalon = null;
    CANSparkMax rightBackTalon = null;

    MotorControllerGroup leftMotors = null;
    MotorControllerGroup rightMotors = null;

    DifferentialDrive differentialDrive = null;
    RocketLeagueDrive drive = null;

    // creates a DriveTrain
    public DriveTrain(){
      loadMotors();
      loadRocketDrive();
    }

    public void loadMotors(){
      // initializes a new talons, in a new piece of memory and states it is on port 0 of the roboRIO.
      leftFrontTalon = new CANSparkMax (Constants.DRIVETRAIN_LEFT_FRONT_TALON, MotorType.kBrushless);
      leftMiddleTalon = new CANSparkMax (Constants.DRIVETRAIN_LEFT_MIDDLE_TALON, MotorType.kBrushless);
      leftBackTalon = new CANSparkMax (Constants.DRIVETRAIN_LEFT_BACK_TALON, MotorType.kBrushless);

      rightFrontTalon = new CANSparkMax (Constants.DRIVETRAIN_RIGHT_FRONT_TALON, MotorType.kBrushless);
      rightMiddleTalon = new CANSparkMax (Constants.DRIVETRAIN_RIGHT_MIDDLE_TALON, MotorType.kBrushless);
      rightBackTalon = new CANSparkMax (Constants.DRIVETRAIN_RIGHT_BACK_TALON, MotorType.kBrushless);

      leftMotors = new MotorControllerGroup(leftFrontTalon, leftMiddleTalon, leftBackTalon);
      rightMotors = new MotorControllerGroup(rightFrontTalon, rightMiddleTalon, rightBackTalon);
      differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    // tank drive method
    public void tankControls(double leftMotors, double rightMotors){
        differentialDrive.tankDrive(leftMotors, rightMotors);
    }

    public void loadRocketDrive(){
      drive = new RocketLeagueDrive(differentialDrive, 
      Robot.controllers.getPrimaryJoystick(),
      Constants.DRIVER_CONTROLLER_PRIMARY_LEFT_TRIGGER, 
      Constants.DRIVER_CONTROLLER_PRIMARY_RIGHT_TRIGGER, 
      Constants.DRIVER_CONTROLLER_PRIMARY_RIGHT_X_AXIS, 
      Constants.DRIVER_CONTROLLER_PRIMARY_LEFT_Y_AXIS);
    }

    public RocketLeagueDrive getDrive(){
      return drive;
    }
  }

