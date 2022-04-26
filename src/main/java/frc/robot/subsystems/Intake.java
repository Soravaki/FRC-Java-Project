// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class Intake extends SubsystemBase{

    MotorController intakeMotor = null;

    public Intake(){
        if (Constants.MODULES_INTAKE_ENABLED){
            loadMotors();
        }
    }

    public void setIntakeMotors(double value) {
        if(intakeMotor != null && Constants.MODULES_INTAKE_ENABLED) {
            intakeMotor.set(value);
        }
    }

    public void loadMotors(){
        intakeMotor = new CANSparkMax(8, MotorType.kBrushless);
    }
}
