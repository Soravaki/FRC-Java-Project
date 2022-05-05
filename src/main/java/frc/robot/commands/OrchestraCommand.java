// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.OrchestraSubsystem;

/** Add your docs here. */
public class OrchestraCommand extends CommandBase {
    private OrchestraSubsystem m_OrchestraSubsystem;
    public OrchestraCommand(){
        m_OrchestraSubsystem = RobotContainer.m_OrchestraSubsystem;
    }

   // Called when the command is initially scheduled.
   @Override
   public void initialize() {
        m_OrchestraSubsystem.loadOrchestra();
   }

   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
        m_OrchestraSubsystem.stopSong();
   }

   @Override
   public void execute(){
    int dPadVal = Robot.controllers.getSecondaryJoystick().getPOV();
    if (dPadVal == 90) m_OrchestraSubsystem.loadSong(1);
    else if (dPadVal == 180) m_OrchestraSubsystem.stopSong();
    else if (dPadVal == 270) m_OrchestraSubsystem.loadSong(-1);
    else if (dPadVal == 0) m_OrchestraSubsystem.playSong();
   }

   // Returns true when the command should end.
   @Override
   public boolean isFinished() {
       return false;
   }
}
