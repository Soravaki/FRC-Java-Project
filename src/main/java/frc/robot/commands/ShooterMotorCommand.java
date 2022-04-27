// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.*;
import frc.robot.subsystems.BallHandlingSubsystems;

/** Add your docs here. */
public class ShooterMotorCommand extends CommandBase{
private BallHandlingSubsystems m_BallHandlingSubsystems;
  public ShooterMotorCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_BallHandlingSubsystems = RobotContainer.m_BallHandlingSubsystems;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   m_BallHandlingSubsystems.setShooterMotors(Constants.SHOOTER_MOTOR_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   m_BallHandlingSubsystems.setShooterMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return false;
  }
}
