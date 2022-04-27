// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class BallHandlingSubsystems extends SubsystemBase{

    MotorController intakeMotor = null;
    CANSparkMax indexerMotor = null;   
    CANSparkMax shooterMotor = null;
    VictorSPX victorMotor = null;

    Solenoid solenoidMotor = null;

    public BallHandlingSubsystems(){
        /* if (Constants.MODULES_PNEUMATICS_ENABLED){
            loadPistons();
        } */
        if (Constants.MODULES_INTAKE_ENABLED){
            loadIntakeMotors();
        }
        if (Constants.MODULES_INDEXER_ENABLED){
            loadIndexerMotors();
        }
        if (Constants.MODULES_SHOOTER_ENABLED){
            loadShooterMotors();
        }
    }
    
    public void loadIntakeMotors(){
        intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushless);
    }

    public void loadIndexerMotors(){
        indexerMotor = new CANSparkMax(Constants.INDEXER_MOTOR, MotorType.kBrushless);
    }

    public void loadShooterMotors(){
        shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR, MotorType.kBrushless);
        victorMotor = new VictorSPX(Constants.VICTOR_MOTOR);
        shooterMotor.setInverted(true);
        victorMotor.setInverted(true);
    }

    public void setIntakeMotors(double value) {
        if(intakeMotor != null && Constants.MODULES_INTAKE_ENABLED) {
            intakeMotor.set(value);
        }
    }

    public void setIndexerMotors(double value) {
        if(indexerMotor != null && Constants.MODULES_INDEXER_ENABLED) {
            indexerMotor.set(value);
        }
    }

    public void setShooterMotors(double value) {
        if(shooterMotor != null && Constants.MODULES_SHOOTER_ENABLED) {
            shooterMotor.set(value);
        }
    }

    public void setFeederMotors(double value){
        if(victorMotor != null && Constants.MODULES_SHOOTER_ENABLED) {
            victorMotor.set(ControlMode.PercentOutput, value);
        }
    }
    /* public void loadPistons(){
        solenoidMotor = new Solenoid(PneumaticsModuleType.REVPH, Constants.INTAKE_SOLENOID_MOTOR);
    } */
}
