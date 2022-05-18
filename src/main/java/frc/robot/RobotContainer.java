// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.OrchestraCommand;
import frc.robot.commands.RocketDrive;
import frc.robot.subsystems.BallHandlingSubsystems;
import frc.robot.subsystems.DriveTrain;

//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.OrchestraSubsystem;
//import frc.robot.subsystems.Indexer;
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
  public static BallHandlingSubsystems m_BallHandlingSubsystems;
  public static OrchestraSubsystem m_OrchestraSubsystem;

  /* public static Intake intake;
  public static Indexer indexer; */

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
    m_BallHandlingSubsystems = new BallHandlingSubsystems();
    m_OrchestraSubsystem = new OrchestraSubsystem();
    //m_OrchestraSubsystem.setDefaultCommand(new OrchestraCommand())
  }


  public DriveTrain getDriveTrain(){
    return m_DriveTrain;
  }

  public BallHandlingSubsystems getBallHandlingSubsystems(){
    return m_BallHandlingSubsystems;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  /* private void configureButtonBindings() {} */

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
