// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

/** Add your docs here. */
public class IntakeMotorCommand extends CommandBase{
    private Intake intake;
    private double direction;

    public IntakeMotorCommand(double direction){
        intake = Robot.m_robotContainer.getIntake();
        this.direction = direction;
        //requires(intake);   
    }

   // Called when the command is initially scheduled.
   @Override
   public void initialize() {
    intake.setIntakeMotors(direction * Constants.INTAKE_MOTOR_SPEED);
   }

   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
    intake.setIntakeMotors(0);
   }

   // Returns true when the command should end.
   @Override
   public boolean isFinished() {
       return false;
   }
}
