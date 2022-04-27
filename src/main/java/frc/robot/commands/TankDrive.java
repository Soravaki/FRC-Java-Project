    // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

/** Add your docs here. */
public class TankDrive extends CommandBase{

    // Drive Train constructor
    public TankDrive(){
        // Currently ends running commands using that subsystem to allow a new command to run
        addRequirements(Robot.m_robotContainer.getDriveTrain());
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Teleop Driving", true);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("Initiating...");
        double leftMotors = -Robot.controllers.getPrimaryJoystick().getRawAxis(Constants.DRIVER_CONTROLLER_PRIMARY_LEFT_Y_AXIS);
        double rightMotors = Robot.controllers.getPrimaryJoystick().getRawAxis(Constants.DRIVER_CONTROLLER_PRIMARY_RIGHT_Y_AXIS);

        Robot.m_robotContainer.getDriveTrain().tankControls(leftMotors, rightMotors); 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // This will make the motors stop running when the command ends by setting movement speed and rotation speed to 0
        Robot.m_robotContainer.getDriveTrain().tankControls(0,0);
        SmartDashboard.putBoolean("Teleop Driving", false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // command runs indefinitely
        return false;
    }
}
