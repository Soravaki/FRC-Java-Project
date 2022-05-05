// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

import frc.robot.Constants;

/** Add your docs here. */
public class OrchestraSubsystem {
    Orchestra orchestra = null;
    TalonFX orchestraMotor1 = null;
    TalonFX orchestraMotor2 = null;
    ArrayList<TalonFX> instruments = null;
    int songNum;

    String[] songs = new String[]{
        "FreedomDive.chrp",
        "SeaShanty2.chrp",
        "song1.chrp"
    };

    public OrchestraSubsystem(){
        loadMotors();
        //loadOrchestra();
    }

    public void loadMotors(){
        instruments = new ArrayList<TalonFX>();
        orchestraMotor1 = new TalonFX(Constants.ORCHESTRA_MOTOR);
        instruments.add(orchestraMotor1);
        /* orchestraMotor2 = new TalonFX(Constants.ORCHESTRA_MOTOR);
        instruments.add(orchestraMotor2); */
        // create a for loop to iterate through the list of motors to add to the instruments ArrayList

        
        //JoystickButton POVButton = new JoystickButton(Robot.controllers.getSecondaryJoystick()
    }

    public void loadOrchestra(){
        orchestra = new Orchestra(instruments);
        songNum = 2;
    }

    public void playSong(){
        orchestra.loadMusic(songs[songNum]);
        orchestra.play();
    }

    /* public void nextSong(){
        songNum++;
        if (songs.length >= songNum){
            songNum = 0;
        }   
        System.out.println("NextSong: " + songNum);
        orchestra.loadMusic(songs[songNum]);
        orchestra.play();
    }

    public void prevSong(){
        songNum--;
        if (songNum < 0){
            songNum = songs.length-1;
        }   
        System.out.println("PrevSong: " + songNum);
        orchestra.loadMusic(songs[songNum]);
        orchestra.play();
    } */

    public void loadSong(int offset){
        songNum+=offset;
        if (songNum >= songs.length){
            songNum = 0;
        }
        if (songNum < 0){
            songNum = songs.length-1;
        }
        orchestra.loadMusic(songs[songNum]);
    }

    public void stopSong(){
        orchestra.stop();
    }
}
