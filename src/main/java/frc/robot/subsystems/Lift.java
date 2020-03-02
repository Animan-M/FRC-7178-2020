/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift extends SubsystemBase {
  /**
   * Creates a new Lift.
   */

  public static WPI_TalonSRX m_leftLift;
  public static WPI_TalonSRX m_rightLift;

  public Lift() {
    m_leftLift = new WPI_TalonSRX(12);
    m_rightLift = new WPI_TalonSRX(15);

    m_leftLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_leftLift.setSelectedSensorPosition(0);

    m_rightLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_rightLift.setSelectedSensorPosition(0);
  }

  public void LiftUp() {
    m_leftLift.set(ControlMode.PercentOutput, 0.7);
    m_rightLift.set(ControlMode.PercentOutput, 0.7);
  }

  public void LiftDown() {
    m_leftLift.set(ControlMode.PercentOutput, -0.5);
    m_rightLift.set(ControlMode.PercentOutput, -0.5);
  }

  public void StopLift() {
    m_leftLift.set(ControlMode.PercentOutput, 0);
    m_rightLift.set(ControlMode.PercentOutput, 0);
  }
  
  public void LeftLiftUp() {
    if(m_leftLift.getSelectedSensorPosition() < 1000000) {
      m_leftLift.set(ControlMode.Velocity, 4000);
    } else {
      m_leftLift.set(ControlMode.Velocity, 0);
    }
  }

  public void RightLiftUp() {
    if(m_rightLift.getSelectedSensorPosition() < 1000000) {
      m_rightLift.set(ControlMode.Velocity, 4000);
    } else {
      m_rightLift.set(ControlMode.Velocity, 0);
    }
  }

  /*
  public double leftLiftPosition() {

  }

  public double rightLiftPosition() {

  }

  public void LiftUp() {
    if(m_leftLift.getSelectedSensorPosition() < 1000000) {
      m_leftLift.set(ControlMode.Velocity, 3500);
    } else {
      m_leftLift.set(ControlMode.Velocity, 0);
    }

    if(m_rightLift.getSelectedSensorPosition() < 1000000) {
      m_rightLift.set(ControlMode.Velocity, 3500);
    } else {
      m_rightLift.set(ControlMode.Velocity, 0);
    }
  }
  */
  

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Lift", m_leftLift.getSelectedSensorPosition());
    SmartDashboard.putNumber("Right Lift", m_rightLift.getSelectedSensorPosition());

    SmartDashboard.putNumber("Left Velocity", m_leftLift.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Right Velocity", m_rightLift.getSelectedSensorVelocity());
  }
 
}
