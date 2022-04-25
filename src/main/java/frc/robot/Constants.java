// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Talons
    public static final int DRIVETRAIN_LEFT_FRONT_TALON = 5;
    public static final int DRIVETRAIN_LEFT_MIDDLE_TALON = 6;
    public static final int DRIVETRAIN_LEFT_BACK_TALON = 4;
    public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 2;
    public static final int DRIVETRAIN_RIGHT_MIDDLE_TALON = 3;
    public static final int DRIVETRAIN_RIGHT_BACK_TALON = 1;
    public static final int DRIVETRAIN_MIDDLE_SPARKMAX = 7;

    // Primary Joystick
    public static final int DRIVER_CONTROLLER_PRIMARY_PORT = 0;
    public static final int DRIVER_CONTROLLER_PRIMARY_LEFT_TRIGGER = 2;
    public static final int DRIVER_CONTROLLER_PRIMARY_RIGHT_TRIGGER = 3;


    public static final int DRIVER_CONTROLLER_PRIMARY_LEFT_X_AXIS = 0;
    public static final int DRIVER_CONTROLLER_PRIMARY_LEFT_Y_AXIS = 1; 
    public static final int DRIVER_CONTROLLER_PRIMARY_RIGHT_X_AXIS = 4; 


    public static final int DRIVER_CONTROLLER_SECONDARY_PORT = 0;

    
    /*
    // Tank Drive Values, deleting soon once done probably
    public static final int DRIVER_CONTROLLER_LEFT_MOTORS = 5;
    public static final int DRIVER_CONTROLLER_RIGHT_MOTORS = 1;
    public static final int DRIVER_CONTROLLER_MIDDLE_MOTORS = 1;
    */

    // Values
    public static final double DEADBAND_VALUE = 0.1; // adjust deadband value for future
}