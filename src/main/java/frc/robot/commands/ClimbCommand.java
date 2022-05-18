// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallHandlingSubsystems;

/** Add your docs here. */
public class ClimbCommand extends CommandBase {
    private BallHandlingSubsystems m_BallHandlingSubsystems;
    private boolean active;
    public ClimbCommand(boolean active){
        this.active = active;
        m_BallHandlingSubsystems = RobotContainer.m_BallHandlingSubsystems;
    }

    // Called when the command is initially scheduled.
   @Override
   public void initialize() {
        addRequirements(RobotContainer.m_BallHandlingSubsystems);
        m_BallHandlingSubsystems.setPistons(active);
   }

   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
    m_BallHandlingSubsystems.setPistons(false);
   }

   // Returns true when the command should end.
   @Override
   public boolean isFinished() {
       return false;
   }
}
;