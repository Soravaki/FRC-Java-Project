// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.*;
import frc.robot.subsystems.BallHandlingSubsystems;

/** Add your docs here. */
public class IntakeMotorCommand extends CommandBase{
    private BallHandlingSubsystems m_BallHandlingSubsystems;
    private double direction;

    public IntakeMotorCommand(double direction){
        //addRequirements(Robot.m_robotContainer.getIntake());
        //RobotContainer rc = Robot.m_robotContainer;
        m_BallHandlingSubsystems = RobotContainer.m_BallHandlingSubsystems;
        this.direction = direction;
        //requires(intake);   
    }

   // Called when the command is initially scheduled.
   @Override
   public void initialize() {
    m_BallHandlingSubsystems.setIntakeMotors(direction * Constants.INTAKE_MOTOR_SPEED);
   }

   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
    m_BallHandlingSubsystems.setIntakeMotors(0);
   }

   // Returns true when the command should end.
   @Override
   public boolean isFinished() {
       return false;
   }
}
