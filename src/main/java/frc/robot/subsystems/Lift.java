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
    m_leftLift = new WPI_TalonSRX(14);
    m_rightLift = new WPI_TalonSRX(12);

    m_leftLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_leftLift.setSelectedSensorPosition(0);

    m_rightLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_rightLift.setSelectedSensorPosition(0);
  }

  public void LiftUp() {
    m_leftLift.set(ControlMode.PercentOutput, 0.2);
    m_rightLift.set(ControlMode.PercentOutput, 0.2);
  }

  public void LiftDown() {
    m_leftLift.set(ControlMode.PercentOutput, -0.2);
    m_rightLift.set(ControlMode.PercentOutput, -0.2);
  }

  public void StopLift() {
    m_leftLift.set(ControlMode.PercentOutput, 0);
    m_rightLift.set(ControlMode.PercentOutput, 0);
  }

  /*
  public double leftLiftPosition() {

  }

  public double rightLiftPosition() {

  }
  */

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Lift", m_leftLift.getSelectedSensorPosition());
    SmartDashboard.putNumber("Right Lift", m_rightLift.getSelectedSensorPosition());

  }
 
}
