// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;

import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.TankDrive;
import frc.robot.commands.RocketDrive;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static DriveTrain m_DriveTrain;
  private static Intake intake;

  // Joystick controller defined here

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // sets default commands on subsystems
    enableSubsystems();
  
    // Configure the button bindings
    Robot.controllers.assignCommands();
  }

  public void enableSubsystems(){
    m_DriveTrain = new DriveTrain();
    m_DriveTrain.setDefaultCommand(new RocketDrive());

    if (Constants.MODULES_INTAKE_ENABLED){
      intake = new Intake();
    }
  }

  public DriveTrain getDriveTrain(){
    return m_DriveTrain;
  }

  public Intake getIntake(){
    return intake;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

}
