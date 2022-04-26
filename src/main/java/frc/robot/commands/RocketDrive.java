    // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** Add your docs here. */
public class RocketDrive extends CommandBase{

    // Drive Train constructor
    public RocketDrive(){
        // Currently ends running commands using that subsystem to allow a new command to run
        addRequirements(RobotContainer.m_DriveTrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Teleop Driving", true);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        RobotContainer.m_DriveTrain.getDrive().driveRobot();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // This will make the motors stop running when the command ends by setting movement speed and rotation speed to 0
        SmartDashboard.putBoolean("Teleop Driving", false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // command runs indefinitely
        return false;
    }
}
