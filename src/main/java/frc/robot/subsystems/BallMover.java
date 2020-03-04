/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallMover extends SubsystemBase {
  /**
   * Creates a new BallMover.
   */
  public static WPI_TalonSRX m_middle;
  public static WPI_TalonSRX m_front;
  public static WPI_TalonSRX m_ballHelp;
  public static DigitalInput _midMove = new DigitalInput(0); //default = true
  public static DigitalInput _pickUp = new DigitalInput(1); //default = true
  public static DigitalInput _endShoot = new DigitalInput(4); //default = false
  public static DigitalInput _pickProxy = new DigitalInput(6); //default = true
  public static DigitalInput _midProxy = new DigitalInput(7); 

  public BallMover() {
    m_middle = new WPI_TalonSRX(10);
    m_front = new WPI_TalonSRX(6);
    m_ballHelp = new WPI_TalonSRX(16);    
  }
  
  public void ballForward() {
    m_middle.set(ControlMode.PercentOutput, -.3); //negative since upside down
    m_front.set(ControlMode.PercentOutput, .3);
  }

  public void ballBackward() {
    m_middle.set(ControlMode.PercentOutput, .3);
    m_front.set(ControlMode.PercentOutput, -0.2);
  }

  public void ballStop() {
    m_middle.set(ControlMode.PercentOutput, 0);
    m_front.set(ControlMode.PercentOutput, 0);
  }
/*
  public void automatedBallMove() {
    if(_pickUp.get() == false) {
      if(_midMove.get() == true) {
        if(_midMove.get() == true) {
          m_middle.set(ControlMode.PercentOutput, -0.2);
          m_ballHelp.set(ControlMode.PercentOutput, 0.5);
        } else if(_pickUp.get() == true){
          m_middle.set(ControlMode.PercentOutput, 0);
          m_ballHelp.set(ControlMode.PercentOutput, 0.5);
        }
      } else if(_midMove.get() == false && _pickUp.get() == false) {
        m_middle.set(ControlMode.PercentOutput, -0.2);
        m_front.set(ControlMode.PercentOutput, 0.2);
        m_ballHelp.set(ControlMode.PercentOutput, 0.5);
      } else if(_midMove.get() == false && _pickUp.get() == false) {
        m_middle.set(ControlMode.PercentOutput, -0.2);
        m_front.set(ControlMode.PercentOutput, 0.2);
        m_ballHelp.set(ControlMode.PercentOutput, 0.5);
      } else {
        m_middle.set(ControlMode.PercentOutput, 0);
        m_front.set(ControlMode.PercentOutput, 0);
        m_ballHelp.set(ControlMode.PercentOutput, 0);
      }
    }
  }
*/
  public void move1() {
    m_middle.set(ControlMode.PercentOutput, -0.3);
  }

  public void move2() {
    m_middle.set(ControlMode.PercentOutput, -0.3);
    m_front.set(ControlMode.PercentOutput, 0.2); 
  }

  public void move3() {
    m_middle.set(ControlMode.PercentOutput, -0.3);
    m_front.set(ControlMode.PercentOutput, 0.2);
    m_ballHelp.set(ControlMode.PercentOutput, 0.5);
  }

  public void StopMove() {
    m_middle.set(ControlMode.PercentOutput, 0);
    m_front.set(ControlMode.PercentOutput, 0);
    m_ballHelp.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("PickUp", _pickUp.get());
    SmartDashboard.putBoolean("MidMove", _midMove.get());
    SmartDashboard.putBoolean("End", _endShoot.get());
    SmartDashboard.putBoolean("Pickup Proximity", _pickProxy.get());
    SmartDashboard.putBoolean("Mid Proximity", _midProxy.get());
  }

}
